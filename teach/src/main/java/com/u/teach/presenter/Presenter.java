package com.u.teach.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bluelinelabs.conductor.Router;
import com.u.teach.contract.ContractView;
import com.u.teach.view.ViewSubscriptionsManager;
import rx.Subscription;

/**
 * Created by saguilera on 1/21/17.
 */
public abstract class Presenter<T extends ContractView> {

    private @NonNull Router router;

    private @Nullable T view;

    public Presenter(@NonNull Router router) {
        this.router = router;
    }

    protected @Nullable T getView() {
        return view;
    }

    protected @Nullable Context getContext() {
        return router.getActivity();
    }

    protected @NonNull Router getRouter() {
        return router;
    }

    public void onAttach(@NonNull T view) {
        this.view = view;
    }

    public void onDetach() {
        this.view = null;
    }

}
