package com.u.teach.controller.register;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.u.teach.R;
import com.u.teach.controller.BaseController;

/**
 * Created by saguilera on 1/20/17.
 */

public class RegisterController extends BaseController {

    @NonNull
    @Override
    protected View onCreateView(@NonNull final LayoutInflater inflater, @NonNull final ViewGroup container) {
        return inflater.inflate(R.layout.controller_register, container, false);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected @Nullable String title() {
        return getResources().getString(R.string.toolbar_register);
    }

}
