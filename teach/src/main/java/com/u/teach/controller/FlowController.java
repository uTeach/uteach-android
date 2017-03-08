package com.u.teach.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
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
            getActionBar().getMenu().clear();

            if (hasActionBar()) {
                getActionBar().setTitle(" " + title());
                getActionBar().setNavigationIcon(R.mipmap.ic_launcher);
                getActionBar().setVisibility(View.VISIBLE);
            } else {
                getActionBar().setVisibility(View.GONE);
            }
        }
    }

    protected boolean hasActionBar() {
        return true;
    }

    protected @Nullable Toolbar getActionBar() {
        return getActivity() == null ? null : (Toolbar) getActivity().findViewById(R.id.activity_main_toolbar);
    }

    protected abstract @Nullable String title();

}
