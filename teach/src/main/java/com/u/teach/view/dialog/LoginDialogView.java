package com.u.teach.view.dialog;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jakewharton.rxbinding.view.RxView;
import com.u.teach.R;
import com.u.teach.contract.dialog.LoginContract;
import com.u.teach.utils.TextUtils;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by saguilera on 1/22/17.
 */

public class LoginDialogView extends LinearLayout implements LoginContract.View {

    private @NonNull TextView readTCView;
    private @NonNull ImageView facebookButton;
    private @NonNull ImageView googleButton;

    @Nullable PublishSubject<Void> termsAndConditionsListener;

    public LoginDialogView(final Context context) {
        super(context);

        inflate(context, R.layout.view_dialog_login, this);

        setOrientation(VERTICAL);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        readTCView = (TextView) findViewById(R.id.view_dialog_login_terms_and_conditions);
        facebookButton = (ImageView) findViewById(R.id.view_dialog_login_facebook);
        googleButton = (ImageView) findViewById(R.id.view_dialog_login_google);

        readTCView.setMovementMethod(LinkMovementMethod.getInstance());
        readTCView.setHighlightColor(Color.TRANSPARENT);
        readTCView.setText(TextUtils.createClickableSpan(getResources().getString(R.string.register_terms_and_conditions),
            new TextUtils.BaseClickableSpan(getContext()) {
                @Override
                public void onClick(final View widget) {
                    if (termsAndConditionsListener != null) {
                        termsAndConditionsListener.onNext(null);
                    }
                }
            }), TextView.BufferType.SPANNABLE);
    }

    public LoginDialogView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        throw new IllegalStateException("This view doesnt support xml injection. Use is programatical only");
    }

    public LoginDialogView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        throw new IllegalStateException("This view doesnt support xml injection. Use is programatical only");
    }

    @Override
    public Observable<Void> observeOnTermsAndConditionsClick() {
        if (termsAndConditionsListener == null) {
            termsAndConditionsListener = PublishSubject.create();
        }

        return termsAndConditionsListener;
    }

    @Override
    public Observable<Void> observeOnFacebookLoginClick() {
        return RxView.clicks(facebookButton);
    }

    @Override
    public Observable<Void> observeOnGoogleLoginClick() {
        return RxView.clicks(googleButton);
    }

}
