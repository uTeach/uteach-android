package com.u.teach.view.home.cards;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.u.teach.R;
import com.u.teach.contract.home.cards.ProfessorCardContract;
import com.u.teach.supplier.home.card.ProfessorCardSupplier;
import com.u.teach.model.entity.Tag;
import com.u.teach.view.misc.ExpertiseView;
import com.u.teach.view.misc.RatingView;
import java.util.List;

/**
 * Created by saguilera on 3/8/17.
 */
public class ProfessorCardView extends CardView
        implements ProfessorCardContract.View {

    private static int bestWidth = 0;

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

        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
            computeBestWidth(),
            getResources().getDimensionPixelSize(R.dimen.view_card_professor_height));
        setLayoutParams(params);

        setRadius(getResources().getDimensionPixelSize(R.dimen.view_card_professor_radius));
        setCardElevation(getResources().getDimensionPixelSize(R.dimen.view_card_professor_elevation));

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

    private int computeBestWidth() {
        if (bestWidth != 0) return bestWidth;

        WindowManager wm = (WindowManager) getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int columns = ProfessorCardSupplier.PROFESSORS_PER_ROW;

        screenWidth -= (2 * getResources().getDimensionPixelSize(R.dimen.home_item_paddings));
        screenWidth -= ((columns + 1) * getResources().getDimensionPixelSize(R.dimen.home_item_paddings));

        return bestWidth = (screenWidth / columns);
    }

}
