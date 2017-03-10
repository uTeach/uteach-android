package com.u.teach.contract.home.cards;

import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import rx.Observable;

/**
 * Created by saguilera on 3/9/17.
 */

public interface NoAccountCardContract {

    interface View extends ContractView {

        Observable<Void> observeOnCreateAccountClick();

    }

    interface Presenter extends ContractPresenter {

    }

}
