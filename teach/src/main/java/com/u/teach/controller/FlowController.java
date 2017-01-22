package com.u.teach.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.u.teach.R;

/**
 * Created by saguilera on 1/22/17.
 */
public abstract class FlowController extends BaseController {

    @Override
    protected void onAttach(@NonNull final View view) {
        super.onAttach(view);

        if (getActionBar() != null) {
            if (hasActionBar()) {
                getActionBar().setTitle(" " + title());
                getActionBar().setIcon(R.mipmap.ic_launcher);
                getActionBar().show();
            } else {
                getActionBar().hide();
            }
        }
    }

    protected boolean hasActionBar() {
        return true;
    }

    protected @Nullable
    ActionBar getActionBar() {
        return getActivity() == null ? null : ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    protected abstract @Nullable String title();

}
