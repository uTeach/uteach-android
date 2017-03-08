package com.u.teach.controller.abstracts;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.coordinators.Coordinator;
import com.squareup.coordinators.CoordinatorProvider;
import com.squareup.coordinators.Coordinators;
import com.u.teach.controller.BaseController;
import com.u.teach.presenter.abstracts.BaseDialogPresenter;
import com.u.teach.view.abstracts.BaseDialogView;

/**
 * Created by saguilera on 1/21/17.
 */
public abstract class BaseDialogController extends BaseController {

    BaseDialogPresenter.Severity severity;
    String title;
    View content;
    boolean cancellable = true;

    @NonNull
    @Override
    protected View onCreateView(@NonNull final LayoutInflater inflater, @NonNull final ViewGroup container) {
        View view = new BaseDialogView(getActivity());

        Coordinators.bind(view, new CoordinatorProvider() {
            @Nullable
            @Override
            public Coordinator provideCoordinator(final View view) {
                return new BaseDialogPresenter.Builder(getRouter())
                    .severity(severity)
                    .title(title)
                    .content(content)
                    .cancellable(cancellable)
                    .build();
            }
        });

        return view;
    }

    public @NonNull BaseDialogController severity(@NonNull BaseDialogPresenter.Severity severity,
        @NonNull String title) {
        this.severity = severity;
        this.title = title;
        return this;
    }

    public @NonNull BaseDialogController content(@NonNull View content) {
        this.content = content;
        return this;
    }

    public @NonNull BaseDialogController cancellable(boolean cancelable) {
        this.cancellable = cancelable;
        return this;
    }

    @Override
    public boolean handleBack() {
        return !cancellable || super.handleBack();
    }

}
