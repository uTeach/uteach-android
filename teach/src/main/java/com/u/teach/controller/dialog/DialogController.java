package com.u.teach.controller.dialog;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.u.teach.contract.dialog.DialogContract;
import com.u.teach.controller.BaseController;
import com.u.teach.presenter.dialog.DialogPresenter;
import com.u.teach.view.dialog.DialogView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by saguilera on 1/21/17.
 */
//TODO is abstract.
public class DialogController extends BaseController {

    private DialogPresenter.Severity severity;
    private String title;
    private View content;

    private DialogContract.Presenter presenter;

    @Nullable
    @Override
    protected String title() {
        return null;
    }

    @Override
    protected boolean hasActionBar() {
        return false;
    }

    public @NonNull DialogController severity(@NonNull DialogPresenter.Severity severity,
            @NonNull String title) {
        this.severity = severity;
        this.title = title;
        return this;
    }

    public @NonNull DialogController content(@NonNull View content) {
        this.content = content;
        return this;
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull final LayoutInflater inflater, @NonNull final ViewGroup container) {
        View view = new DialogView(getActivity());

        presenter = new DialogPresenter.Builder(getApplicationContext())
            .severity(severity)
            .title(title)
            .content(content)
            .build();

        return view;
    }

    @Override
    protected void onAttach(@NonNull final View view) {
        super.onAttach(view);
        presenter.onAttach((DialogContract.View) view);

        presenter.getOnDismissEvent()
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
