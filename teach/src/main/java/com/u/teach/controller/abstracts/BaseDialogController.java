package com.u.teach.controller.abstracts;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.u.teach.contract.abstracts.BaseDialogContract;
import com.u.teach.controller.BaseController;
import com.u.teach.presenter.abstracts.BaseDialogPresenter;
import com.u.teach.view.abstracts.BaseDialogView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by saguilera on 1/21/17.
 */
public abstract class BaseDialogController extends BaseController {

    private BaseDialogPresenter.Severity severity;
    private String title;
    private View content;
    private boolean cancellable = true;

    private BaseDialogContract.Presenter presenter;

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

    @NonNull
    @Override
    protected View onCreateView(@NonNull final LayoutInflater inflater, @NonNull final ViewGroup container) {
        View view = new BaseDialogView(getActivity());

        presenter = new BaseDialogPresenter.Builder(getRouter())
            .severity(severity)
            .title(title)
            .content(content)
            .build();
        presenter.setCancellable(cancellable);

        return view;
    }

    @Override
    protected void onAttach(@NonNull final View view) {
        super.onAttach(view);
        presenter.onAttach((BaseDialogContract.View) view);

        presenter.observeOnDismissEvent()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(this.<Void>bindToLifecycle())
            .take(1)
            .subscribe(new Action1<Void>() {
                @Override
                public void call(final Void aVoid) {
                    getRouter().popCurrentController();
                }
            });
    }

    @Override
    protected void onDetach(@NonNull final View view) {
        super.onDetach(view);
        presenter.onDetach();
    }

}
