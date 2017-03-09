package com.u.teach.view.home.cards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.u.teach.R;
import com.u.teach.contract.home.cards.HeaderCardContract;
import com.u.teach.utils.MetricsUtils;

/**
 * Created by saguilera on 3/8/17.
 */
public class HeaderCardView extends TextView
        implements HeaderCardContract.View {

    private static final int VIEW_HEIGHT_DP = 56;
    private static final int VIEW_PADDING_DP = 12;

    private static final float TEXT_SIZE = 16f;

    public HeaderCardView(final Context context) {
        super(context);

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            (int) MetricsUtils.convertDpToPixel(VIEW_HEIGHT_DP)));
        setGravity(Gravity.CENTER_VERTICAL);
        setPadding((int) MetricsUtils.convertDpToPixel(VIEW_PADDING_DP),
            (int) MetricsUtils.convertDpToPixel(VIEW_PADDING_DP),
            (int) MetricsUtils.convertDpToPixel(VIEW_PADDING_DP),
            (int) MetricsUtils.convertDpToPixel(VIEW_PADDING_DP));
        setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.transparent, null));
        setTextSize(TEXT_SIZE);
        setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
    }

    public HeaderCardView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        throw new IllegalStateException("This view cant be used from XML");
    }

    public HeaderCardView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        throw new IllegalStateException("This view cant be used from XML");
    }

    public HeaderCardView(final Context context, final AttributeSet attrs, final int defStyleAttr,
        final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        throw new IllegalStateException("This view cant be used from XML");
    }

    @Override
    public void setTitle(@NonNull final CharSequence charSequence) {
        setText(charSequence);
    }

}
