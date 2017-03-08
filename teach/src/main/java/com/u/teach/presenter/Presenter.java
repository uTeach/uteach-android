package com.u.teach.presenter;

import android.content.Context;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.bluelinelabs.conductor.Router;
import com.squareup.coordinators.Coordinator;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;
import com.u.teach.contract.ContractView;

/**
 * Created by saguilera on 1/21/17.
 */
public abstract class Presenter<VIEW extends ContractView> extends Coordinator {

    private @NonNull Router router;

    public Presenter(@NonNull Router router) {
        this.router = router;
    }

    protected @Nullable Context getContext() {
        return router.getActivity();
    }

    protected @NonNull Router getRouter() {
        return router;
    }

    @NonNull
    @CheckResult
    protected final <T> LifecycleTransformer<T> bindToLifecycle(@NonNull View view) {
        return RxLifecycleAndroid.bindView(view);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void attach(final View view) {
        super.attach(view);
        onAttach((VIEW) view);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void detach(final View view) {
        super.detach(view);
        onDetach((VIEW) view);
    }

    protected abstract void onAttach(final VIEW view);
    protected void onDetach(final VIEW view) {}

}
