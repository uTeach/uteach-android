package com.u.teach.view.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.u.teach.contract.home.HomeCardContainerContract;

/**
 * Created by saguilera on 3/8/17.
 */
public class HomeCardContainerView extends ScrollView implements HomeCardContainerContract.View {

    private @NonNull LinearLayout container;

    public HomeCardContainerView(final Context context) {
        this(context, null);
    }

    public HomeCardContainerView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeCardContainerView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public HomeCardContainerView(final Context context, final AttributeSet attrs, final int defStyleAttr,
        final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        container = new LinearLayout(context);
        container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT));
        container.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    @Override
    public void addCard(final View view) {
        container.addView(view);
    }

    @Override
    public void removeCard(final View view) {
        container.removeView(view);
    }

    @Override
    public void clearCards() {
        container.removeAllViews();
    }

}
