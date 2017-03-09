package com.u.teach.view.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.u.teach.R;
import com.u.teach.contract.home.HomeCardContainerContract;
import com.u.teach.list.adapter.GenericAdapter;
import java.util.List;

/**
 * Created by saguilera on 3/8/17.
 */
public class HomeCardContainerView extends RecyclerView implements HomeCardContainerContract.View {

    @NonNull GenericAdapter adapter;

    public HomeCardContainerView(final Context context) {
        this(context, null);
    }

    public HomeCardContainerView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeCardContainerView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorAccent, null));

        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        manager.setInitialPrefetchItemCount(4);
        setLayoutManager(manager);

        setAdapter(adapter = new GenericAdapter());
    }

    @Override
    public void setData(final @NonNull List<GenericAdapter.ItemSupplier> cards) {
        adapter.data(cards);
    }

}
