package com.u.teach.presenter.dialog;

import android.support.annotation.NonNull;
import android.widget.Toast;
import com.bluelinelabs.conductor.Router;
import com.u.teach.contract.dialog.LoginContract;
import com.u.teach.presenter.Presenter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.ReplaySubject;

/**
 * Created by saguilera on 1/22/17.
 */
public class LoginDialogPresenter extends Presenter<LoginContract.View> implements LoginContract.Presenter {

    private ReplaySubject<Login> listener = ReplaySubject.create();

    public LoginDialogPresenter(@NonNull final Router router) {
        super(router);
    }

    @Override
    public void onAttach(@NonNull final LoginContract.View view) {
        super.onAttach(view);

        addSubscription(view.observeOnFacebookLoginClick()
            .observeOn(Schedulers.newThread())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<Void>() {
                @Override
                public void call(final Void aVoid) {
                    //TODO get access token from fb.. and that stuff.
                    notifyLogin(null);
                }
            }));

        addSubscription(view.observeOnGoogleLoginClick()
            .observeOn(Schedulers.newThread())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<Void>() {
                @Override
                public void call(final Void aVoid) {
                    //TODO get access token from google.. and that stuff.
                    notifyLogin(null);
                }
            }));

        addSubscription(view.observeOnTermsAndConditionsClick()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe(new Action1<Void>() {
                @Override
                public void call(final Void aVoid) {
                    //TODO getrouter and go to terms and conditions, remove pop up or not ??
                    // Use slide down to dismiss ?
                    Toast.makeText(getContext(), "terms and conditions", Toast.LENGTH_SHORT).show();
                }
            }));
    }

    void notifyLogin(@NonNull Login login) {
        listener.onNext(login);
    }

    @Override
    public Observable<Login> onLoginEvent() {
        return listener.asObservable();
    }

    public class Login {

        String accessToken;
        String type;

    }

}
