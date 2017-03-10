package com.u.teach.view.home.cards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.u.teach.R;
import com.u.teach.contract.home.cards.TrendingProfessorsCardContract;
import com.u.teach.list.adapter.GenericAdapter;
import com.u.teach.view.home.recyclerview.TrendingProfessorsItemDecorator;
import java.util.List;

/**
 * Created by saguilera on 3/9/17.
 */

public class TrendingProfessorsCardView extends RecyclerView
        implements TrendingProfessorsCardContract.View {

    private GenericAdapter adapter;

    public TrendingProfessorsCardView(final Context context) {
        this(context, null);
    }

    public TrendingProfessorsCardView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TrendingProfessorsCardView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT));

        setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorAccent, null));

        addItemDecoration(new TrendingProfessorsItemDecorator(getResources().getDimensionPixelSize(R.dimen.home_item_paddings)));

        setLayoutManager(new LinearLayoutManager(context, HORIZONTAL, false));
        setAdapter(adapter = new GenericAdapter());
    }

    @Override
    public void setData(@NonNull final List<GenericAdapter.ItemSupplier> cards) {
        adapter.data(cards);
    }

}
