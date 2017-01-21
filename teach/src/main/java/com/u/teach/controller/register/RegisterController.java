package com.u.teach.controller.register;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.u.teach.R;
import com.u.teach.contract.card.PickUserTypeCardContract;
import com.u.teach.controller.BaseController;
import com.u.teach.model.AccessToken.UserType;
import com.u.teach.presenter.card.PickUserTypeCardPresenter;

/**
 * Created by saguilera on 1/20/17.
 */

public class RegisterController extends BaseController {

    private PickUserTypeCardContract.Presenter professorCardPresenter;
    private PickUserTypeCardContract.Presenter studentCardPresenter;

    @NonNull
    @Override
    protected View onCreateView(@NonNull final LayoutInflater inflater, @NonNull final ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_register, container, false);

        studentCardPresenter = new PickUserTypeCardPresenter(
            (PickUserTypeCardContract.View) view.findViewById(R.id.controller_register_view_card_student));
        studentCardPresenter.setUserType(UserType.STUDENT);
        professorCardPresenter = new PickUserTypeCardPresenter(
            (PickUserTypeCardContract.View) view.findViewById(R.id.controller_register_view_card_professor));
        professorCardPresenter.setUserType(UserType.PROFESSOR);

        return view;
    }

    @Override
    protected void onAttach(@NonNull final View view) {
        super.onAttach(view);

        studentCardPresenter.onAttach();
        professorCardPresenter.onAttach();
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
