package com.u.teach.view.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.u.teach.contract.home.HomeCardContainerContract;
import com.u.teach.presenter.home.adapter.HomeCardContainerAdapter;
import java.util.List;

/**
 * Created by saguilera on 3/8/17.
 */
public class HomeCardContainerView extends RecyclerView implements HomeCardContainerContract.View {

    @NonNull HomeCardContainerAdapter adapter;

    public HomeCardContainerView(final Context context) {
        this(context, null);
    }

    public HomeCardContainerView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeCardContainerView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        setAdapter(adapter = new HomeCardContainerAdapter());
    }

    @Override
    public void setData(final @NonNull HomeCardContainerAdapter.CardComparator<?> comparator,
        final @NonNull List<HomeCardContainerAdapter.CardRenderer> cards) {
        adapter.data(comparator, cards);
    }

}
