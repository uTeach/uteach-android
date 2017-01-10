package com.u.teach.activity.splash;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.u.teach.R;
import com.u.teach.model.entity.User;
import com.u.teach.networking.AccessTokenManager;
import com.u.teach.networking.LogIn.LogInService;
import com.u.teach.networking.RestClient;
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
public class SplashActivity extends Activity {

    /**
     * Default minimum time for the activity to be shown
     */
    private static final long SPLASH_DEFAULT_TIME = 6L;

    /**
     * Current user, if available
     */
    @Nullable User me;

    /**
     * Flag for knowing if the default minimum time has been achieved
     */
    boolean defaultTimePassed;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        if (AccessTokenManager.getInstance().read(this) != null) {
            // If we have an access token, log the user
            LogInService service = RestClient.create(this, true).create(LogInService.class);
            service.logIn().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(final Throwable throwable) {
                        // TODO handle error
                    }
                })
                .doOnNext(new Action1<User>() {
                    @Override
                    public void call(final User user) {
                        me = user;
                        if (defaultTimePassed) {
                            SplashActivity.this.onFinish();
                        }
                    }
                }).subscribe();
        }

        Observable.timer(SPLASH_DEFAULT_TIME, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<Long>() {
                @Override
                public void call(final Long aLong) {
                    defaultTimePassed = true;
                    SplashActivity.this.onFinish();
                }
            });
    }

    /**
     * Logic for finishing the splash.
     * This should only be called either when all requirements are fullfilled and the minimum time has passed.
     */
    void onFinish() {
        if (AccessTokenManager.getInstance().read(this) != null) {
            // A request for the user was available
            if (me != null) {
                // The request already finished, go to home with credentials
                // startActivity(new Intent()); // TODO
            }
            // If not wait the request to finish
        } else {
            // If no request was able to perform, go to home directly
            // startActivity(new Intent()); // TODO
        }

        Toast.makeText(this, "sup homies", Toast.LENGTH_LONG).show();
    }

}
