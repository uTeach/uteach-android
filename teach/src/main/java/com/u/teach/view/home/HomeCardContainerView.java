package com.u.teach.view.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.u.teach.R;
import com.u.teach.contract.home.HomeCardContainerContract;
import com.u.teach.utils.adapter.GenericAdapter;
import com.u.teach.view.home.recyclerview.BaseHomeItemDecorator;
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

        addItemDecoration(new BaseHomeItemDecorator(getResources().getDimensionPixelSize(R.dimen.home_item_paddings)));

        adapter = new GenericAdapter();

        GridLayoutManager manager = new GridLayoutManager(context, GenericAdapter.MAX_SPAN_SIZE);
        manager.setInitialPrefetchItemCount(4);
        manager.setSpanSizeLookup(adapter.getSpanSizeLookup());
        setLayoutManager(manager);

        setAdapter(adapter);
    }

    @Override
    public void setData(final @NonNull List<GenericAdapter.ItemSupplier> cards) {
        adapter.data(cards);
    }

}
