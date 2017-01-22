package com.u.teach.controller.register;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.u.teach.R;
import com.u.teach.contract.register.AccountTypeContract;
import com.u.teach.controller.FlowController;
import com.u.teach.model.AccessToken.UserType;
import com.u.teach.presenter.register.AccountTypePresenter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by saguilera on 1/20/17.
 */

public class RegisterController extends FlowController {

    private AccountTypeContract.Presenter professorCardPresenter;
    private AccountTypeContract.Presenter studentCardPresenter;

    @NonNull
    @Override
    protected View onCreateView(@NonNull final LayoutInflater inflater, @NonNull final ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_register, container, false);

        studentCardPresenter = new AccountTypePresenter(getRouter(), UserType.STUDENT);
        professorCardPresenter = new AccountTypePresenter(getRouter(), UserType.PROFESSOR);

        Observable.merge(
            studentCardPresenter.getCardPickEvent(),
            professorCardPresenter.getCardPickEvent())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<UserType>bindToLifecycle())
                .first()
                .subscribe(new Action1<UserType>() {
                    @Override
                    public void call(final UserType userType) {
                        //TODO
                        // We have the selected usertype, do something.
                        Log.w("RegisterController", userType.name());
                        showDialog(new LoginDialogController());
                    }
                });

        return view;
    }

    @Override
    protected void onAttach(@NonNull final View view) {
        super.onAttach(view);

        studentCardPresenter.onAttach(
            (AccountTypeContract.View) view.findViewById(R.id.controller_register_view_card_student));
        professorCardPresenter.onAttach(
            (AccountTypeContract.View) view.findViewById(R.id.controller_register_view_card_professor));
    }

    @Override
    protected void onDetach(@NonNull final View view) {
        super.onDetach(view);

        studentCardPresenter.onDetach();
        professorCardPresenter.onDetach();
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected @Nullable String title() {
        return getResources().getString(R.string.toolbar_register);
    }

}
