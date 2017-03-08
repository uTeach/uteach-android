package com.u.teach.contract.home;

import android.support.annotation.NonNull;
import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import com.u.teach.presenter.home.adapter.HomeCardContainerAdapter;
import com.u.teach.view.home.HomeCardContainerView;
import java.util.List;

/**
 * Created by saguilera on 3/8/17.
 */

public interface HomeCardContainerContract {

    interface View extends ContractView {

        void setData(final @NonNull HomeCardContainerView.Comparator<?> comparator,
            final @NonNull List<HomeCardContainerAdapter.CardRenderer> cards);

    }

    interface Presenter extends ContractPresenter {

    }

}
