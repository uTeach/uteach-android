package com.u.teach.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.u.teach.contract.ContractView;
import com.u.teach.view.ViewSubscriptionsManager;
import rx.Subscription;

/**
 * Created by saguilera on 1/21/17.
 */
public abstract class Presenter<T extends ContractView> {

    private @Nullable T view;
    private @NonNull ViewSubscriptionsManager subscriptionsManager;

    public Presenter() {
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

    public void onAttach(@NonNull T view) {
        this.view = view;
    }

    public void onDetach() {
        this.view = null;
        clearSubscriptions();
    }

}
