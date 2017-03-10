package com.u.teach.list.home.card.supplier;

import android.content.Context;
import android.support.annotation.NonNull;
import com.u.teach.list.adapter.GenericAdapter;
import com.u.teach.presenter.home.cards.NoAccountCardPresenter;
import com.u.teach.view.home.cards.NoAccountCardView;

/**
 * Created by saguilera on 3/9/17.
 */
public class NoAccountCardSupplier extends GenericAdapter.ItemSupplier<NoAccountCardView> {

    public NoAccountCardSupplier(@NonNull final Context context) {
        super(context);
    }

    @NonNull
    @Override
    public NoAccountCardView createView() {
        return new NoAccountCardView(context());
    }

    @NonNull
    @Override
    public GenericAdapter.ItemPresenter createPresenter() {
        return new NoAccountCardPresenter();
    }

    @Override
    public int spanSize() {
        return 1;
    }

    @Override
    public boolean isSameItem(@NonNull final GenericAdapter.ItemSupplier supplier) {
        return type() == supplier.type();
    }

    @Override
    public boolean isSameContent(@NonNull final GenericAdapter.ItemSupplier supplier) {
        return isSameItem(supplier);
    }

}
