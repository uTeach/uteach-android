package com.u.teach.contract.register;

import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import com.u.teach.model.AccessToken.UserType;
import rx.Observable;

/**
 * Created by saguilera on 1/21/17.
 */
public interface AccountTypeContract {

    interface View extends ContractView {

        Observable<Void> observeOnCardPickedEvent();

    }

    interface Presenter extends ContractPresenter<View> {

        void onCardPicked();
        Observable<UserType> observeOnCardPickedEvent();

    }

}
