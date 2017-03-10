package com.u.teach.contract.home.cards;

import android.support.annotation.NonNull;
import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import com.u.teach.list.adapter.GenericAdapter;
import java.util.List;

/**
 * Created by saguilera on 3/9/17.
 */
public interface TrendingProfessorsCardContract {

    interface View extends ContractView {

        void setData(final @NonNull List<GenericAdapter.ItemSupplier> cards);

    }

    interface Presenter extends ContractPresenter {

    }

}
