package com.u.teach.contract.home.cards;

import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;

/**
 * Created by saguilera on 3/8/17.
 */
public interface CardHeaderContract {

    interface View extends ContractView {

        void setTitle(CharSequence charSequence);

    }

    interface Presenter extends ContractPresenter {

    }

}
