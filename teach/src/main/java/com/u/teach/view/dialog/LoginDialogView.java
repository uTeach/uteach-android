package com.u.teach.view.dialog;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.u.teach.R;
import com.u.teach.utils.TextUtils;

/**
 * Created by saguilera on 1/22/17.
 */

public class LoginDialogView extends LinearLayout {

    private @NonNull TextView readTCView;
    private @NonNull ImageView facebookButton;
    private @NonNull ImageView googleButton;

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
                    Toast.makeText(getContext(), "TODO, show terms and conditions", Toast.LENGTH_SHORT).show();
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

}
