package com.u.teach.contract.register;

import android.support.annotation.NonNull;
import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import com.u.teach.model.AccessToken.UserType;
import rx.Observable;

/**
 * Created by saguilera on 1/21/17.
 */
public interface AccountTypeContract {

    interface View extends ContractView {

        @NonNull Observable<Void> observeOnCardPickedEvent();

    }

    interface Presenter extends ContractPresenter {

        void onCardPicked();
        @NonNull Observable<UserType> observeOnCardPickedEvent();

    }

}
