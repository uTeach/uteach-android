package com.u.teach.presenter.register;

import android.support.annotation.NonNull;
import com.bluelinelabs.conductor.Router;
import com.u.teach.contract.register.AccountTypeContract;
import com.u.teach.model.AccessToken.UserType;
import com.u.teach.presenter.Presenter;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/**
 * Created by saguilera on 1/21/17.
 */
public class AccountTypePresenter extends Presenter<AccountTypeContract.View>
        implements AccountTypeContract.Presenter {

    private final @NonNull UserType type;
    private PublishSubject<UserType> subject;

    public AccountTypePresenter(@NonNull Router router,
        @NonNull UserType type) {
        super(router);

        this.type = type;

        subject = PublishSubject.create();
    }

    @Override
    public void onAttach(@NonNull AccountTypeContract.View view) {
        super.onAttach(view);

        Subscription clickSubscription = view.observeOnCardPickedEvent()
            .take(1)
            .subscribe(new Action1<Void>() {
                @Override
                public void call(final Void aVoid) {
                    onCardPicked();
                }
            });
        addSubscription(clickSubscription);
    }

    @Override
    public Observable<UserType> getCardPickEvent() {
        return subject;
    }

    @Override
    public void onCardPicked() {
        subject.onNext(type);
        subject.onCompleted();

        clearSubscriptions();
    }

}