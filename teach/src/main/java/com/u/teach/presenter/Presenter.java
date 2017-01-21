package com.u.teach.presenter;

import android.support.annotation.NonNull;
import com.u.teach.contract.ContractView;
import com.u.teach.view.ViewSubscriptionsManager;
import rx.Subscription;

/**
 * Created by saguilera on 1/21/17.
 */
public abstract class Presenter<T extends ContractView> {

    //TODO Check if this might leak
    private @NonNull T view;
    private @NonNull ViewSubscriptionsManager subscriptionsManager;

    public Presenter(@NonNull T view) {
        this.view = view;
        subscriptionsManager = new ViewSubscriptionsManager();
    }

    protected @NonNull T getView() {
        return view;
    }

    protected void addSubscription(@NonNull Subscription subscription) {
        subscriptionsManager.add(subscription);
    }

    protected void clearSubscriptions() {
        subscriptionsManager.clear();
    }

    public void onAttach() {}
    public void onDetach() {
        clearSubscriptions();
    }

}
