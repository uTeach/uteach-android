package com.u.teach.presenter.home;

import com.u.teach.contract.home.HomeCardContainerContract;
import com.u.teach.list.adapter.GenericAdapter;
import com.u.teach.list.home.renderer.CardHeaderRenderer;
import com.u.teach.presenter.Presenter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saguilera on 3/8/17.
 */
public class HomeCardContainerPresenter extends Presenter<HomeCardContainerContract.View>
        implements HomeCardContainerContract.Presenter {

    @Override
    protected void onAttach(final HomeCardContainerContract.View view) {
        List<GenericAdapter.ItemRenderer> mocks = new ArrayList<>();
        mocks.add(new CardHeaderRenderer(getContext(), "Mock 1"));
        mocks.add(new CardHeaderRenderer(getContext(), "Mock 2"));
        mocks.add(new CardHeaderRenderer(getContext(), "Mock 3"));
        mocks.add(new CardHeaderRenderer(getContext(), "Mock 4"));
        view.setData(mocks);
    }

}
