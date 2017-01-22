package com.u.teach.presenter.dialog;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.bluelinelabs.conductor.Router;
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
public class BaseDialogPresenter extends Presenter<DialogContract.View> implements DialogContract.Presenter {

    private @NonNull Severity severity;
    private @NonNull String title;

    private @Nullable View content;

    private boolean cancellable = true;

    private PublishSubject<Void> dismissSubject;

    BaseDialogPresenter(Builder builder) {
        super(builder.router);
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
    public Observable<Void> observeOnDismissEvent() {
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

        @NonNull Router router;
        @Nullable Severity severity;
        @Nullable String title;
        @Nullable View content;

        public Builder(@NonNull Router router) {
            this.router = router;
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

        public @NonNull
        BaseDialogPresenter build() {
            if (severity == null || title == null) {
                throw new IllegalStateException("Missing params");
            }

            return new BaseDialogPresenter(this);
        }

    }

}