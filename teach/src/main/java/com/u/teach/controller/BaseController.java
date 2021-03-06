package com.u.teach.controller;

import android.support.annotation.NonNull;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.bluelinelabs.conductor.rxlifecycle.RxController;
import com.u.teach.controller.abstracts.BaseDialogController;
import com.u.teach.utils.RouterInteractor;

/**
 * Created by saguilera on 1/20/17.
 */
public abstract class BaseController extends RxController {

    @SuppressWarnings("ConstantConditions")
    protected void showDialog(@NonNull BaseDialogController controller) {
        RouterInteractor.instance().auxRouter()
            .setPopsLastView(true)
            .setRoot(RouterTransaction.with(controller)
                .popChangeHandler(new FadeChangeHandler())
                .pushChangeHandler(new FadeChangeHandler()));
    }

}
