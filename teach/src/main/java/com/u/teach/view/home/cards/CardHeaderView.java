package com.u.teach.view.home.cards;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.u.teach.R;
import com.u.teach.contract.home.cards.CardHeaderContract;
import com.u.teach.utils.MetricsUtils;

/**
 * Created by saguilera on 3/8/17.
 */
public class CardHeaderView extends TextView
        implements CardHeaderContract.View {

    private static final int VIEW_HEIGHT_DP = 36;
    private static final int VIEW_PADDING_DP = 8;

    public CardHeaderView(final Context context) {
        super(context);

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            (int) MetricsUtils.convertDpToPixel(VIEW_HEIGHT_DP)));
        setGravity(Gravity.CENTER_VERTICAL);
        setPadding((int) MetricsUtils.convertDpToPixel(VIEW_PADDING_DP),
            (int) MetricsUtils.convertDpToPixel(VIEW_PADDING_DP),
            (int) MetricsUtils.convertDpToPixel(VIEW_PADDING_DP),
            (int) MetricsUtils.convertDpToPixel(VIEW_PADDING_DP));
        setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.transparent, null));
    }

    public CardHeaderView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        throw new IllegalStateException("This view cant be used from XML");
    }

    public CardHeaderView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        throw new IllegalStateException("This view cant be used from XML");
    }

    public CardHeaderView(final Context context, final AttributeSet attrs, final int defStyleAttr,
        final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        throw new IllegalStateException("This view cant be used from XML");
    }

    @Override
    public void setTitle(final CharSequence charSequence) {
        setText(charSequence);
    }

}
