package com.u.teach.presenter.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.u.teach.R;
import com.u.teach.contract.dialog.DialogContract;
import com.u.teach.presenter.Presenter;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * Created by saguilera on 1/21/17.
 */
public class DialogPresenter extends Presenter<DialogContract.View> implements DialogContract.Presenter {

    private @NonNull Severity severity;
    private @NonNull String title;

    private @Nullable View content;

    private boolean cancellable = true;

    private PublishSubject<Void> dismissSubject;

    DialogPresenter(Builder builder) {
        super(builder.context);
        this.severity = builder.severity;
        this.title = builder.title;
        this.content = builder.content;

        dismissSubject = PublishSubject.create();
    }

    @Override
    public void setCancellable(boolean cancellable) {
        this.cancellable = cancellable;
    }

    @Override
    public Observable<Void> getOnDismissEvent() {
        return dismissSubject;
    }

    @Override
    public void onDismiss() {
        dismissSubject.onNext(null);
        dismissSubject.onCompleted();

        clearSubscriptions();
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onAttach(@NonNull final DialogContract.View view) {
        view.setCancellable(cancellable);
        view.setSeverityTitle(title);

        Subscription subscription = view.observeOnCancelEvent()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe(new Action1<Void>() {
                @Override
                public void call(final Void aVoid) {
                    onDismiss();
                }
            });
        addSubscription(subscription);

        if (content != null) {
            view.setContentView(content);
        }

        switch (severity) {
            case ERROR:
            case WARNING:
            case INFO:
                //TODO
                view.setSeverityImage(ContextCompat.getDrawable(getContext(), R.mipmap.ic_launcher));
        }
    }

    public enum Severity {
        ERROR,
        WARNING,
        INFO
    }

    public static class Builder {

        @NonNull Context context;
        @Nullable Severity severity;
        @Nullable String title;
        @Nullable View content;

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        public @NonNull Builder severity(@NonNull Severity severity) {
            this.severity = severity;
            return this;
        }

        public @NonNull Builder title(@NonNull String title) {
            this.title = title;
            return this;
        }

        public @NonNull Builder content(@NonNull View content) {
            this.content = content;
            return this;
        }

        public @NonNull DialogPresenter build() {
            if (severity == null || title == null) {
                throw new IllegalStateException("Missing params");
            }

            return new DialogPresenter(this);
        }

    }

}