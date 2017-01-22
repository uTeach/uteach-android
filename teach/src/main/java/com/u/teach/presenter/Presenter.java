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
    private @NonNull ViewSubscriptionsManager subscriptionsManager;

    public Presenter(@NonNull Router router) {
        this.router = router;
        subscriptionsManager = new ViewSubscriptionsManager();
    }

    protected @Nullable T getView() {
        return view;
    }

    protected void addSubscription(@NonNull Subscription subscription) {
        subscriptionsManager.add(subscription);
    }

    protected void clearSubscriptions() {
        subscriptionsManager.clear();
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
        clearSubscriptions();
    }

}
