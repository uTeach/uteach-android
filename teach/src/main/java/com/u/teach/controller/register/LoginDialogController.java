package com.u.teach.controller.register;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.u.teach.R;
import com.u.teach.contract.register.LoginContract;
import com.u.teach.controller.abstracts.BaseDialogController;
import com.u.teach.model.AccessToken;
import com.u.teach.presenter.abstracts.BaseDialogPresenter;
import com.u.teach.presenter.register.LoginDialogPresenter;
import com.u.teach.view.register.LoginDialogView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by saguilera on 1/22/17.
 */

public class LoginDialogController extends BaseDialogController {

    private @NonNull LoginContract.View view;
    private @NonNull LoginContract.Presenter presenter;

    @NonNull
    @Override
    protected View onCreateView(@NonNull final LayoutInflater inflater, @NonNull final ViewGroup container) {
        severity(BaseDialogPresenter.Severity.WARNING, getResources().getString(R.string.login_dialog_title));

        presenter = new LoginDialogPresenter(getRouter());
        view = new LoginDialogView(getApplicationContext());

        content((View) view);

        presenter.onLoginEvent()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .compose(this.<AccessToken.Provider>bindToLifecycle())
            .take(1)
            .subscribe(new Action1<AccessToken.Provider>() {
                @Override
                public void call(final AccessToken.Provider login) {
                    //TODO do our login :)
                    Toast.makeText(getApplicationContext(), "Login..", Toast.LENGTH_SHORT).show();
                }
            });

        return super.onCreateView(inflater, container);
    }

    @Override
    protected void onAttach(@NonNull final View view) {
        super.onAttach(view);

        presenter.onAttach(this.view);
    }

    @Override
    protected void onDetach(@NonNull final View view) {
        super.onDetach(view);

        presenter.onDetach();
    }

}