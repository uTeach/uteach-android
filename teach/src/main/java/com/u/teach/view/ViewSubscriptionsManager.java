package com.u.teach.view;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import rx.Subscription;

/**
 * Created by saguilera on 1/21/17.
 */

public class ViewSubscriptionsManager {

    private @NonNull List<Subscription> subscriptions;

    public ViewSubscriptionsManager() {
        subscriptions = new ArrayList<>();
    }

    public void add(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void remove(Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscriptions.remove(subscription);
    }

    public void clear() {
        for (Subscription subscription : new ArrayList<>(subscriptions)) {
            remove(subscription);
        }
    }

}
