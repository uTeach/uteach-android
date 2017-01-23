package com.u.teach.controller;

import android.view.ViewGroup;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.bluelinelabs.conductor.rxlifecycle.RxController;
import com.u.teach.R;

/**
 * Created by saguilera on 1/20/17.
 */
public abstract class BaseController extends RxController {

    @SuppressWarnings("ConstantConditions")
    protected void showDialog(BaseController controller) {
        getChildRouter((ViewGroup) getActivity().findViewById(R.id.activity_dialog_container))
            .setPopsLastView(true)
            .setRoot(RouterTransaction.with(controller)
                .popChangeHandler(new FadeChangeHandler())
                .pushChangeHandler(new FadeChangeHandler()));
    }

}
