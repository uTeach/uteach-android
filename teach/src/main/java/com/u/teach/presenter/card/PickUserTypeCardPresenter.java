package com.u.teach.presenter.card;

import android.support.annotation.NonNull;
import com.bluelinelabs.conductor.Router;
import com.u.teach.contract.card.PickUserTypeCardContract;
import com.u.teach.model.AccessToken.UserType;
import com.u.teach.presenter.Presenter;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/**
 * Created by saguilera on 1/21/17.
 */
public class PickUserTypeCardPresenter extends Presenter<PickUserTypeCardContract.View>
        implements PickUserTypeCardContract.Presenter {

    private final @NonNull UserType type;
    private PublishSubject<UserType> subject;

    public PickUserTypeCardPresenter(@NonNull Router router,
        @NonNull UserType type) {
        super(router);

        this.type = type;

        subject = PublishSubject.create();
    }

    @Override
    public void onAttach(@NonNull PickUserTypeCardContract.View view) {
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
