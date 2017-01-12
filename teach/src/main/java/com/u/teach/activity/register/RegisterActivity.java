package com.u.teach.activity.register;

import android.os.Bundle;
import com.u.teach.R;
import com.u.teach.activity.DefaultActivity;

/**
 * Created by saguilera on 1/11/17.
 */
public class RegisterActivity extends DefaultActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.toolbar_register));
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(getDrawable(R.mipmap.ic_launcher));
        }
    }

}
