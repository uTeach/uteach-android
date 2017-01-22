package com.u.teach.view.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.u.teach.R;
import com.u.teach.contract.dialog.DialogContract;
import com.u.teach.utils.MetricsUtils;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * Created by saguilera on 1/21/17.
 */

public class DialogView extends FrameLayout implements DialogContract.View {

    private @NonNull View innerContainer;

    private @NonNull ImageView severityImage;
    private @NonNull TextView severityTitle;
    private @NonNull ViewGroup container;

    private boolean cancellable;

    private @Nullable PublishSubject<Void> listener;

    public DialogView(final Context context) {
        super(context);

        inflate(context, R.layout.view_dialog, this);

        innerContainer = findViewById(R.id.view_dialog_inner_container);
        severityImage = (ImageView) findViewById(R.id.view_dialog_severity_image);
        severityTitle = (TextView) findViewById(R.id.view_dialog_severity_title);
        container = (ViewGroup) findViewById(R.id.view_dialog_content);

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        setBackgroundColor(ContextCompat.getColor(context, R.color.dialog_shadow));

        int padding = (int) MetricsUtils.convertDpToPixel(getResources().getDimension(R.dimen.dialog_padding));
        setPadding(padding, padding, padding, padding);
    }

    public DialogView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        throw new IllegalStateException("This view doesnt support xml injection. Use is programatical only");
    }

    public DialogView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        throw new IllegalStateException("This view doesnt support xml injection. Use is programatical only");
    }

    public DialogView(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        throw new IllegalStateException("This view doesnt support xml injection. Use is programatical only");
    }

    @Override
    public void setCancellable(boolean cancellable) {
        this.cancellable = cancellable;
    }

    @Override
    public Subscription subscribeOnCancelevent(@NonNull Action1<Void> func) {
        if (listener == null) {
            listener = PublishSubject.create();
        }

        return listener
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(func);
    }

    @Override
    public boolean isCancellable() {
        return cancellable;
    }

    @Override
    public void setContentView(@NonNull View view) {
        container.removeAllViews();
        container.addView(view);
    }

    @Override
    public void setSeverityImage(@NonNull Drawable drawable) {
        severityImage.setImageDrawable(drawable);
    }

    @Override
    public void setSeverityTitle(@NonNull String title) {
        severityTitle.setText(title);
    }

    @Override
    public boolean onInterceptTouchEvent(final MotionEvent ev) {
        Rect outRect = new Rect();
        int[] location = new int[2];

        innerContainer.getDrawingRect(outRect);
        innerContainer.getLocationOnScreen(location);
        outRect.offset(location[0], location[1]);

        boolean interceptEvent = !outRect.contains((int) ev.getRawX(), (int) ev.getRawY());
        interceptEvent &= ev.getAction() == MotionEvent.ACTION_DOWN;
        interceptEvent &= isCancellable();

        if (interceptEvent && listener != null) {
            listener.onNext(null);
        }

        return interceptEvent;
    }

}