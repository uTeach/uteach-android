package com.u.teach.supplier.home.card;

import android.content.Context;
import android.support.annotation.NonNull;
import com.u.teach.utils.adapter.GenericAdapter;
import com.u.teach.presenter.home.cards.TrendingProfessorsCardPresenter;
import com.u.teach.view.home.cards.TrendingProfessorsCardView;
import java.util.List;

/**
 * Created by saguilera on 3/10/17.
 */

public class TrendingProfessorsCardSupplier extends GenericAdapter.ItemSupplier<TrendingProfessorsCardView> {

    private @NonNull List<GenericAdapter.ItemSupplier> professorsSupplier;

    public TrendingProfessorsCardSupplier(@NonNull final Context context,
            @NonNull List<GenericAdapter.ItemSupplier> professorsSupplier) {
        super(context);
        this.professorsSupplier = professorsSupplier;
    }

    @NonNull
    @Override
    public TrendingProfessorsCardView createView() {
        return new TrendingProfessorsCardView(context());
    }

    @NonNull
    @Override
    public GenericAdapter.ItemPresenter<?> createPresenter() {
        return new TrendingProfessorsCardPresenter(professorsSupplier);
    }

    @Override
    public int spanSize() {
        return 1;
    }

    @Override
    public boolean isSameItem(@NonNull final GenericAdapter.ItemSupplier supplier) {
        return supplier.type() == type();
    }

    @Override
    public boolean isSameContent(@NonNull final GenericAdapter.ItemSupplier supplier) {
        return isSameItem(supplier);
    }

}
