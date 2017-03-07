package com.u.teach.contract.abstracts;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import rx.Observable;

/**
 * Created by saguilera on 1/21/17.
 */

public interface BaseDialogContract {

    interface View extends ContractView {

        Observable<Void> observeOnCancelEvent();
        void setCancellable(boolean cancellable);
        boolean isCancellable();
        void setContentView(@NonNull android.view.View view);
        void setSeverityImage(@NonNull Drawable drawable);
        void setSeverityTitle(@NonNull String title);

    }

    interface Presenter extends ContractPresenter<View> {

    }

}
