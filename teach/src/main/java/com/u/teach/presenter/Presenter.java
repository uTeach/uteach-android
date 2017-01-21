package com.u.teach.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.u.teach.contract.ContractView;
import com.u.teach.view.ViewSubscriptionsManager;
import rx.Subscription;

/**
 * Created by saguilera on 1/21/17.
 */
public abstract class Presenter<T extends ContractView> {

    private @NonNull Context context;

    private @Nullable T view;
    private @NonNull ViewSubscriptionsManager subscriptionsManager;

    public Presenter(@NonNull Context context) {
        this.context = context;
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

    protected @NonNull Context getContext() {
        return context;
    }

    public void onAttach(@NonNull T view) {
        this.view = view;
    }

    public void onDetach() {
        this.view = null;
        clearSubscriptions();
    }

}
