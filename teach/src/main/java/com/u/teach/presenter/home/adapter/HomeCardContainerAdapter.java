package com.u.teach.presenter.home.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.coordinators.Coordinator;
import com.squareup.coordinators.CoordinatorProvider;
import com.squareup.coordinators.Coordinators;
import com.u.teach.contract.ContractView;
import com.u.teach.presenter.Presenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saguilera on 3/8/17.
 */
public class HomeCardContainerAdapter extends RecyclerView.Adapter<HomeCardContainerAdapter.CardViewHolder> {

    @NonNull List<CardRenderer> array;
    final @NonNull Map<Integer, CardRenderer> typeFactory;

    public HomeCardContainerAdapter() {
        array = new ArrayList<>();
        typeFactory = new HashMap<>();
    }

    public void data(@NonNull CardComparator<?> comparator,
        @NonNull List<CardRenderer> cards) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(comparator);

        array = cards;

        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public CardViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return typeFactory.get(viewType).createViewHolder();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(final CardViewHolder holder, final int position) {
        final CardRenderer renderer = array.get(position);
        Coordinators.bind(holder.view(), new CoordinatorProvider() {
            @Nullable
            @Override
            public Coordinator provideCoordinator(final View view) {
                return renderer.presenter();
            }
        });
    }

    @Override
    public int getItemViewType(final int position) {
        CardRenderer renderer = array.get(position);
        typeFactory.put(renderer.type(), renderer);
        return renderer.type();
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    /**
     * View for a card
     */
    public static abstract class CardViewHolder extends RecyclerView.ViewHolder {

        public CardViewHolder(final View itemView) {
            super(itemView);
        }

        public abstract @NonNull View view();

    }

    /**
     * Presenter for a card
     * @param <ViewHolder> that is able to present
     */
    public static abstract class CardPresenter<ViewHolder extends ContractView> extends Presenter<ViewHolder> {}

    /**
     * Class that is able to link generic presenters with views
     */
    public static abstract class CardRenderer<ViewHolder extends CardViewHolder & ContractView> {

        private CardPresenter<ViewHolder> currentPresenter;

        /**
         * Each card should know how to create its view holder and its presenter.
         * Of course it will delegate responsibility to each of them on how to draw or
         * react accordingly.
         */
        public abstract ViewHolder createViewHolder();
        public abstract CardPresenter<ViewHolder> createPresenter();

        /**
         * For applying new changes.
         *
         * @param renderer another renderer
         * @return if the item is the same. This does not mean the contents are equals.
         * Eg I have User "John" safe and sound. If I get again "John" but with a broken leg,
         * this returns 'true'. If I got "Joe", it is 'false'
         */
        public abstract boolean isSameItem(@NonNull CardRenderer renderer);

        /**
         * For applying new changes
         *
         * @return true if they are the same item AND they have the same content, false otherwise
         */
        public abstract boolean isSameContent(@NonNull CardRenderer renderer);

        /**
         * Presenter should be reusable since a renderer will always present
         * only one view
         * @return presenter
         */
        CardPresenter<ViewHolder> presenter() {
            if (currentPresenter != null) {
                return presenter();
            }

            return currentPresenter = createPresenter();
        }

        /**
         * Type of the renderer, this is used for knowing the type of the view in the recyclerview
         * Each renderer has a single view type in the recyclerview!
         */
        public int type() {
            return getClass().getName().hashCode();
        }

    }

    /**
     * Comparator for doing changes in the adapter
     */
    public static abstract class CardComparator<Object extends HomeCardContainerAdapter.CardRenderer> extends DiffUtil.Callback {

        private @NonNull List<Object> oldList;
        private @NonNull List<Object> newList;

        public CardComparator(@NonNull List<Object> oldList, @NonNull List<Object> newList) {
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

        @Override
        public boolean areItemsTheSame(final int oldItemPosition, final int newItemPosition) {
            return oldList.get(oldItemPosition).isSameItem(newList.get(newItemPosition));
        }

        @Override
        public boolean areContentsTheSame(final int oldItemPosition, final int newItemPosition) {
            return oldList.get(oldItemPosition).isSameContent(newList.get(newItemPosition));
        }

    }

}


