package com.u.teach.controller.register;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.Router;
import com.squareup.coordinators.Coordinator;
import com.squareup.coordinators.CoordinatorProvider;
import com.u.teach.R;
import com.u.teach.controller.FlowController;
import com.u.teach.model.AccessToken.UserType;
import com.u.teach.presenter.AbstractPresenterGraph;
import com.u.teach.presenter.Presenter;
import com.u.teach.presenter.register.AccountTypePresenter;
import com.u.teach.utils.CoordinatorsInstaller;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by saguilera on 1/20/17.
 */
public class RegisterController extends FlowController {

    @NonNull
    @Override
    protected View onCreateView(@NonNull final LayoutInflater inflater, @NonNull final ViewGroup container) {
        final ViewGroup view = (ViewGroup) inflater.inflate(R.layout.controller_register, container, false);
        final PresenterGraph graph = new PresenterGraph(getRouter());

        Observable.merge(graph.cardPickEventObservables())
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

        CoordinatorsInstaller.installBinder(view, new CoordinatorProvider() {
            @Nullable
            @Override
            public Coordinator provideCoordinator(final View view) {
                return graph.present(view);
            }
        });

        return view;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected @Nullable String title() {
        return getResources().getString(R.string.toolbar_register);
    }

    private static class PresenterGraph extends AbstractPresenterGraph {

        private static final int KEY_STUDENT = 0;
        private static final int KEY_PROFESSOR = 1;

        public PresenterGraph(@NonNull Router router) {
            add(KEY_STUDENT, new AccountTypePresenter(router, UserType.STUDENT));
            add(KEY_PROFESSOR, new AccountTypePresenter(router, UserType.PROFESSOR));
        }

        @SuppressWarnings({ "unchecked", "ConstantConditions" })
        public Observable<UserType>[] cardPickEventObservables() {
            Observable<UserType>[] observables = new Observable[size()];
            int index = 0;
            for (Presenter presenter : asArray()) {
                observables[index] = ((AccountTypePresenter) presenter).observeOnCardPickedEvent();
                index++;
            }
            return observables;
        }

        @Nullable
        @Override
        public Presenter<?> present(@NonNull final View view) {
            int key;
            switch (view.getId()) {
                case R.id.controller_register_view_card_student:
                    key = KEY_STUDENT;
                    break;
                case R.id.controller_register_view_card_professor:
                    key = KEY_PROFESSOR;
                    break;
                default:
                    return null;
            }

            return get(key);
        }

        @Override
        public int size() {
            return 2;
        }
    }

}
