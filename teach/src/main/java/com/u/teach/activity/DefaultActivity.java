package com.u.teach.activity;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import rx.Subscription;

/**
 * Default activity every uTeach activity should extend from to benefit from all boilerplate stuff
 * Created by saguilera on 1/11/17.
 */
public abstract class DefaultActivity extends Activity {

    private List<Subscription> subscriptions;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscriptions = new ArrayList<>();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (Subscription subscription : subscriptions)
            if (!subscription.isUnsubscribed())
                subscription.unsubscribe();
    }

    protected void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    protected void removeSubscription(Subscription subscription) {
        subscriptions.remove(subscription);
    }

}
