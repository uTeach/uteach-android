package com.u.teach.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.u.teach.R;
import com.u.teach.activity.register.RegisterActivity;
import com.u.teach.model.entity.User;
import com.u.teach.networking.AccessTokenManager;
import com.u.teach.networking.RestClient;
import com.u.teach.networking.user.UserService;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Splash Activity
 *
 * Created by saguilera on 1/8/17.
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * Default minimum time for the activity to be shown
     */
    private static final long SPLASH_DEFAULT_TIME = 6L;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_splash);

        if (AccessTokenManager.getInstance().read(this) != null) {
            // If we have an access token, get the user
            UserService service = RestClient.with(this).create(UserService.class);
            service.currentUser().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                //.compose(this.<User>bindUntilEvent(ActivityEvent.DESTROY))
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(final Throwable throwable) {
                        // TODO handle error
                        SplashActivity.this.onFinish(throwable, null);
                    }
                })
                .doOnNext(new Action1<User>() {
                    @Override
                    public void call(final User user) {
                        SplashActivity.this.onFinish(null, user);
                    }
                }).subscribe();
        }

        Observable.timer(SPLASH_DEFAULT_TIME, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            //.compose(this.<Long>bindUntilEvent(ActivityEvent.DESTROY))
            .subscribe(new Action1<Long>() {
                @Override
                public void call(final Long aLong) {
                    SplashActivity.this.onFinish(null, null);
                }
            });
    }

    /**
     * Logic for finishing the splash.
     * This should only be called either when all requirements are fullfilled and the minimum time has passed.
     */
    void onFinish(@Nullable Throwable ex, @Nullable User user) {
        if (AccessTokenManager.getInstance().read(this) != null) {
            // A request for the user was available
            if (user != null) {
                // The request already finished, go to home with credentials
                // startActivity(new Intent()); // TODO
            }

            if (ex != null) {
                // The request had errors, go to home directly too
            }

            // If not wait the request to finish
        } else {
            // If no request was able to perform, go to home directly
            // startActivity(new Intent()); // TODO
        }

        startActivity(new Intent(this, RegisterActivity.class));
    }

}
