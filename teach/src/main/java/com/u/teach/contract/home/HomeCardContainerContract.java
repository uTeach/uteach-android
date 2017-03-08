package com.u.teach.contract.home;

import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;

/**
 * Created by saguilera on 3/8/17.
 */

public interface HomeCardContainerContract {

    interface View extends ContractView {

        void addCard(android.view.View view);
        void removeCard(android.view.View view);
        void clearCards();

    }

    interface Presenter extends ContractPresenter {

    }

}
