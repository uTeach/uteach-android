package com.u.teach.list.home.renderer;

import android.content.Context;
import android.support.annotation.NonNull;
import com.u.teach.list.adapter.GenericAdapter;
import com.u.teach.presenter.home.cards.HeaderCardPresenter;
import com.u.teach.view.home.cards.HeaderCardView;

/**
 * Created by saguilera on 3/8/17.
 */
public class HeaderCardRenderer extends GenericAdapter.ItemRenderer<HeaderCardView> {

    private final @NonNull String title;

    public HeaderCardRenderer(final @NonNull Context context, final @NonNull String title) {
        super(context);
        this.title = title;
    }

    @NonNull
    @Override
    public HeaderCardView createView() {
        return new HeaderCardView(context());
    }

    @NonNull
    @Override
    public GenericAdapter.ItemPresenter createPresenter() {
        return new HeaderCardPresenter(title);
    }

    @Override
    public boolean isSameItem(@NonNull final GenericAdapter.ItemRenderer renderer) {
        return type() == renderer.type();
    }

    @Override
    public boolean isSameContent(@NonNull final GenericAdapter.ItemRenderer renderer) {
        boolean same = isSameItem(renderer);

        if (!same) return false;

        HeaderCardRenderer cardRenderer = (HeaderCardRenderer) renderer;
        return (title.contentEquals(cardRenderer.title));
    }

}
