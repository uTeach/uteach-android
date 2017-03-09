package com.u.teach.presenter.home.cards;

import android.support.annotation.NonNull;
import com.u.teach.contract.home.cards.CardHeaderContract;
import com.u.teach.list.adapter.GenericAdapter;

/**
 * Created by saguilera on 3/8/17.
 */

public class CardHeaderPresenter extends GenericAdapter.ItemPresenter<CardHeaderContract.View>
    implements CardHeaderContract.Presenter {

    private @NonNull String title;

    public CardHeaderPresenter(@NonNull String title) {
        this.title = title;
    }

    @Override
    protected void onAttach(final CardHeaderContract.View view) {
        view.setTitle(title);
    }

}
