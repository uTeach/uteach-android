package com.u.teach.contract.card;

import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import com.u.teach.model.AccessToken;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by saguilera on 1/21/17.
 */

public interface PickUserTypeCardContract {

    interface View extends ContractView {

        Subscription subscribeOnCardPicked(final Action1<Void> onCardPicked);

    }

    interface Presenter extends ContractPresenter {

        void onCardPicked();
        void setUserType(AccessToken.UserType userType);

    }

}
