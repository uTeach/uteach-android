package com.u.teach.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.u.teach.R;
import com.u.teach.controller.splash.SplashController;

/**
 * Created by saguilera on 1/20/17.
 */
public class MainActivity extends AppCompatActivity {

    private @NonNull Router router;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.activity_main_toolbar));

        router = Conductor.attachRouter(this,
            (ViewGroup) findViewById(R.id.activity_main_container),
            savedInstanceState);

        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(new SplashController()));
        }
    }

    @Override
    public void onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed();
        }
    }

}
