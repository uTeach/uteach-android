package com.u.teach.list.home.renderer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.u.teach.list.adapter.GenericAdapter;
import com.u.teach.presenter.home.cards.CardHeaderPresenter;
import com.u.teach.view.home.cards.CardHeaderView;
import java.lang.ref.WeakReference;

/**
 * Created by saguilera on 3/8/17.
 */
public class CardHeaderRenderer extends GenericAdapter.ItemRenderer {

    private final WeakReference<Context> context;
    private final @NonNull String title;

    public CardHeaderRenderer(final @NonNull Context context, final @NonNull String title) {
        this.context = new WeakReference<>(context);
        this.title = title;
    }

    @Override
    public View createView() {
        return new CardHeaderView(context.get());
    }

    @Override
    public GenericAdapter.ItemPresenter createPresenter() {
        return new CardHeaderPresenter(title);
    }

    @Override
    public boolean isSameItem(@NonNull final GenericAdapter.ItemRenderer renderer) {
        return type() == renderer.type();
    }

    @Override
    public boolean isSameContent(@NonNull final GenericAdapter.ItemRenderer renderer) {
        boolean same = isSameItem(renderer);

        if (!same) return false;

        CardHeaderRenderer cardRenderer = (CardHeaderRenderer) renderer;
        return (title.contentEquals(cardRenderer.title));
    }

}
