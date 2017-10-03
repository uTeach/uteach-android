package com.u.teach.contract.home;

import android.support.annotation.NonNull;
import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import com.u.teach.utils.adapter.GenericAdapter;
import java.util.List;

/**
 * Created by saguilera on 3/8/17.
 */

public interface HomeCardContainerContract {

    interface View extends ContractView {

        void setData(final @NonNull List<GenericAdapter.ItemSupplier> cards);

    }

    interface Presenter extends ContractPresenter {

    }

}
