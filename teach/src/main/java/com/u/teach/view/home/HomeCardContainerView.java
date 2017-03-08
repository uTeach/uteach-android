package com.u.teach.view.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
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
    public void setData(final @NonNull Comparator<?> comparator,
        final @NonNull List<HomeCardContainerAdapter.CardRenderer> cards) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(comparator);

        adapter.setData(cards);

        diffResult.dispatchUpdatesTo(adapter);
    }

    public static abstract class Comparator<Object extends HomeCardContainerAdapter.CardRenderer> extends DiffUtil.Callback {

        private @NonNull List<Object> oldList;
        private @NonNull List<Object> newList;

        public Comparator(@NonNull List<Object> oldList, @NonNull List<Object> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() {
            return oldList.size();
        }

        @Override
        public int getNewListSize() {
            return newList.size();
        }

        protected @NonNull List<Object> oldList() { return oldList; }
        protected @NonNull List<Object> newList() { return newList; }

    }

}
