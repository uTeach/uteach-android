package com.u.teach.contract.register;

import android.support.annotation.NonNull;
import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import rx.Observable;

/**
 * Created by saguilera on 1/22/17.
 */

public interface LoginContract {

    interface View extends ContractView {

        @NonNull Observable<Void> observeOnTermsAndConditionsClick();
        @NonNull Observable<Void> observeOnFacebookLoginClick();
        @NonNull Observable<Void> observeOnGoogleLoginClick();

    }

    interface Presenter extends ContractPresenter {

    }

}
