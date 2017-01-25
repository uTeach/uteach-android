package com.u.teach.contract.register;

import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import com.u.teach.model.AccessToken;
import rx.Observable;

/**
 * Created by saguilera on 1/22/17.
 */

public interface LoginContract {

    interface View extends ContractView {

        Observable<Void> observeOnTermsAndConditionsClick();
        Observable<Void> observeOnFacebookLoginClick();
        Observable<Void> observeOnGoogleLoginClick();

    }

    interface Presenter extends ContractPresenter<View> {

        Observable<AccessToken.Provider> observeOnLoginEvent();

    }

}
