package com.u.teach.controller.register;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.coordinators.Coordinator;
import com.squareup.coordinators.CoordinatorProvider;
import com.squareup.coordinators.Coordinators;
import com.u.teach.R;
import com.u.teach.controller.abstracts.BaseDialogController;
import com.u.teach.model.AccessToken;
import com.u.teach.networking.ReactiveModel;
import com.u.teach.networking.interactor.credentials.CredentialsInteractor;
import com.u.teach.presenter.abstracts.BaseDialogPresenter;
import com.u.teach.presenter.register.LoginDialogPresenter;
import com.u.teach.view.register.LoginDialogView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by saguilera on 1/22/17.
 */
@SuppressLint("ValidController")
public class LoginDialogController extends BaseDialogController {

    @NonNull
    @Override
    protected View onCreateView(@NonNull final LayoutInflater inflater, @NonNull final ViewGroup container) {
        View view = new LoginDialogView(getApplicationContext());
        content(view);
        severity(BaseDialogPresenter.Severity.WARNING, getResources().getString(R.string.login_dialog_title));

        Coordinators.bind(view, new CoordinatorProvider() {
            @Nullable
            @Override
            public Coordinator provideCoordinator(final View view) {
                return new LoginDialogPresenter();
            }
        });

        CredentialsInteractor.instance().observeToken()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .compose(this.<ReactiveModel<AccessToken>>bindToLifecycle())
            .subscribe(new Action1<ReactiveModel<AccessToken>>() {
                @Override
                public void call(final ReactiveModel<AccessToken> accessTokenReactiveModel) {
                    // TODO Do stuff.
                }
            });

        return super.onCreateView(inflater, container);
    }

}
