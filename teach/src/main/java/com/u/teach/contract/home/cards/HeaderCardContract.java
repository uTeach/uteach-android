package com.u.teach.contract.home.cards;

import android.support.annotation.NonNull;
import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;

/**
 * Created by saguilera on 3/8/17.
 */
public interface HeaderCardContract {

    interface View extends ContractView {

        void setTitle(@NonNull CharSequence charSequence);

    }

    interface Presenter extends ContractPresenter {

    }

}
