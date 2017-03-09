package com.u.teach.presenter.home.cards;

import android.support.annotation.NonNull;
import com.u.teach.contract.home.cards.HeaderCardContract;
import com.u.teach.list.adapter.GenericAdapter;

/**
 * Created by saguilera on 3/8/17.
 */

public class HeaderCardPresenter extends GenericAdapter.ItemPresenter<HeaderCardContract.View>
    implements HeaderCardContract.Presenter {

    private @NonNull String title;

    public HeaderCardPresenter(@NonNull String title) {
        this.title = title;
    }

    @Override
    protected void onAttach(@NonNull final HeaderCardContract.View view) {
        view.setTitle(title);
    }

}
