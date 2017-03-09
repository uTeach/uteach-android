package com.u.teach.presenter.abstracts;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.u.teach.R;
import com.u.teach.contract.abstracts.BaseDialogContract;
import com.u.teach.presenter.Presenter;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by saguilera on 1/21/17.
 */
public class BaseDialogPresenter extends Presenter<BaseDialogContract.View> implements BaseDialogContract.Presenter {

    private @NonNull Severity severity;
    private @NonNull String title;

    private @Nullable View content;

    private boolean cancellable;

    BaseDialogPresenter(@NonNull Builder builder) {
        super();
        this.severity = builder.severity;
        this.title = builder.title;
        this.content = builder.content;
        this.cancellable = builder.cancellable;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onAttach(@NonNull final BaseDialogContract.View view) {
        view.setCancellable(cancellable);
        view.setSeverityTitle(title);

        view.observeOnCancelEvent()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .compose(this.<Void>bindToLifecycle((View) view))
            .subscribe(new Action1<Void>() {
                @Override
                public void call(final Void aVoid) {
                    getAuxiliaryRouter().popCurrentController();
                }
            });

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

        @Nullable Severity severity;
        @Nullable String title;
        @Nullable View content;
        boolean cancellable = true;

        public Builder() {}

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

        public @NonNull Builder cancellable(boolean cancellable) {
            this.cancellable = cancellable;
            return this;
        }

        public @NonNull BaseDialogPresenter build() {
            if (severity == null || title == null) {
                throw new IllegalStateException("Missing params");
            }

            return new BaseDialogPresenter(this);
        }

    }

}