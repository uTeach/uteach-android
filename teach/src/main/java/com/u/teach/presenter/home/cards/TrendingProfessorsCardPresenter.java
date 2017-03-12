package com.u.teach.presenter.home.cards;

import android.support.annotation.NonNull;
import com.u.teach.contract.home.cards.TrendingProfessorsCardContract;
import com.u.teach.utils.adapter.GenericAdapter;
import java.util.List;

/**
 * Created by saguilera on 3/10/17.
 */
public class TrendingProfessorsCardPresenter extends GenericAdapter.ItemPresenter<TrendingProfessorsCardContract.View>
        implements TrendingProfessorsCardContract.Presenter {

    private @NonNull List<GenericAdapter.ItemSupplier> professors;

    public TrendingProfessorsCardPresenter(@NonNull List<GenericAdapter.ItemSupplier> professors) {
        this.professors = professors;
    }

    @Override
    protected void onAttach(@NonNull final TrendingProfessorsCardContract.View view) {
        view.setData(professors);
    }

}
