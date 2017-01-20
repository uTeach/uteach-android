package com.u.teach.activity.register;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewOutlineProvider;
import com.u.teach.R;

/**
 * Created by saguilera on 1/11/17.
 */
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.toolbar_register));
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(R.id.activity_register_professor_container).setElevation(6);
            findViewById(R.id.activity_register_professor_container).setOutlineProvider(ViewOutlineProvider.BOUNDS);
            findViewById(R.id.activity_register_student_container).setElevation(6);
            findViewById(R.id.activity_register_student_container).setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
    }

}
