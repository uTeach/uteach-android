package com.u.teach.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import rx.Subscription;

/**
 * Abstract activity in charge of managing the reactive common stuff
 *
 * Created by saguilera on 1/11/17.
 */
public abstract class RxActivity extends AppCompatActivity {

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
