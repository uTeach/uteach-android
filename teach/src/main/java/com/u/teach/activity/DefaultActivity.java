package com.u.teach.activity;

/**
 * Default activity every uTeach activity should extend from to benefit from all boilerplate stuff
 * Created by saguilera on 1/11/17.
 */
public abstract class DefaultActivity extends RxActivity {

    protected void hideActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

}