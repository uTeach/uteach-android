package com.u.teach.view.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.jakewharton.rxbinding.view.RxView;
import com.u.teach.R;
import com.u.teach.contract.card.PickUserTypeCardContract;
import com.u.teach.utils.MetricsUtils;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by saguilera on 1/20/17.
 */

public class PickUserTypeCardView extends CardView implements PickUserTypeCardContract.View {

    private static final int RADIUS_DP = 2;
    private static final int ELEVATION_DP = 8;
    private static final int PADDING_DP = 8;

    private static final int TYPE_NAN = 0;
    private static final int TYPE_STUDENT = 1;
    private static final int TYPE_PROFESSOR = 2;

    public PickUserTypeCardView(final Context context) {
        this(context, null);
    }

    public PickUserTypeCardView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PickUserTypeCardView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.view_card_pick_user_type, this);

        setRadius(MetricsUtils.convertDpToPixel(RADIUS_DP));
        setCardElevation(MetricsUtils.convertDpToPixel(ELEVATION_DP));

        int contentPadding = (int) MetricsUtils.convertDpToPixel(PADDING_DP);
        setContentPadding(contentPadding,
            contentPadding,
            contentPadding,
            contentPadding);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
            attrs,
            R.styleable.PickUserTypeCardView,
            0, 0);

        int userType = typedArray.getInt(R.styleable.PickUserTypeCardView_user_type, TYPE_NAN);

        switch (userType) {
            case TYPE_PROFESSOR:
                //TODO
            case TYPE_STUDENT:
                ((ImageView) findViewById(R.id.view_card_pick_user_type_image)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                break;
            default:
                throw new IllegalStateException("No user_type provided to " + getClass().getSimpleName());
        }

        typedArray.recycle();
    }

    @Override
    public Subscription subscribeOnCardPicked(final Action1<Void> onCardPicked) {
        return RxView.clicks(this)
            .take(1)
            .subscribe(onCardPicked);
    }

}