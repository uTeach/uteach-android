package com.u.teach.contract.dialog;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by saguilera on 1/21/17.
 */

public interface DialogContract {

    interface View extends ContractView {

        Subscription subscribeOnCancelevent(@NonNull Action1<Void> func);
        void setCancellable(boolean cancellable);
        boolean isCancellable();
        void setContentView(@NonNull android.view.View view);
        void setSeverityImage(@NonNull Drawable drawable);
        void setSeverityTitle(@NonNull String title);

    }

    interface Presenter extends ContractPresenter<View> {

        Observable<Void> getOnDismissEvent();
        void onDismiss();
        void setCancellable(boolean cancellable);

    }

}
