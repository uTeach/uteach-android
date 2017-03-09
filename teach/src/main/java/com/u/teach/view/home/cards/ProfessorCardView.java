package com.u.teach.view.home.cards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.u.teach.R;
import com.u.teach.contract.home.cards.ProfessorCardContract;
import com.u.teach.model.entity.Tag;
import com.u.teach.utils.MetricsUtils;
import com.u.teach.view.misc.ExpertiseView;
import com.u.teach.view.misc.RatingView;
import java.util.List;

/**
 * Created by saguilera on 3/8/17.
 */
public class ProfessorCardView extends CardView
        implements ProfessorCardContract.View {

    private static final float VIEW_WIDTH_DP = 46;
    private static final float VIEW_HEIGHT_DP = 120;

    private @NonNull TextView nameView;
    private @NonNull ImageView imageView;
    private @NonNull ExpertiseView expertiseView;
    private @NonNull RatingView ratingView;
    private @NonNull FrameLayout tagsView;

    public ProfessorCardView(final Context context) {
        this(context, null);
    }

    public ProfessorCardView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProfessorCardView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.view_card_professor, this);

        setLayoutParams(new ViewGroup.LayoutParams(
            (int) MetricsUtils.convertDpToPixel(VIEW_WIDTH_DP),
            (int) MetricsUtils.convertDpToPixel(VIEW_HEIGHT_DP)));

        nameView = (TextView) findViewById(R.id.view_card_professor_name);
        imageView = (ImageView) findViewById(R.id.view_card_professor_image);
        expertiseView = (ExpertiseView) findViewById(R.id.view_card_professor_expertise);
        ratingView = (RatingView) findViewById(R.id.view_card_professor_rating);
        tagsView = (FrameLayout) findViewById(R.id.view_card_professor_tags);
    }

    @Override
    public void setImage(@NonNull final String url) {
        // TODO
        imageView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public void setName(@NonNull final String name) {
        nameView.setText(name);
    }

    @NonNull
    @Override
    public View getExpertise() {
        return expertiseView;
    }

    @NonNull
    @Override
    public View getRating() {
        return ratingView;
    }

    @Override
    public void setTags(@NonNull final List<Tag> tags) {
        // TODO
    }

}
