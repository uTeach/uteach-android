package com.u.teach.presenter.card;

import android.util.Log;
import com.u.teach.contract.card.PickUserTypeCardContract;
import com.u.teach.model.AccessToken;
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

    private UserType type;
    private PublishSubject<UserType> subject;

    public PickUserTypeCardPresenter(PickUserTypeCardContract.View view) {
        super(view);
        subject = PublishSubject.create();
    }

    @Override
    public void onAttach() {
        Subscription clickSubscription = getView().subscribeOnCardPicked(new Action1<Void>() {
            @Override
            public void call(final Void aVoid) {
                onCardPicked();
            }
        });

        addSubscription(clickSubscription);
    }

    @Override
    public void setUserType(UserType type) {
        this.type = type;
    }

    @Override
    public Observable<UserType> onTypeSelected() {
        return subject;
    }

    @Override
    public void onCardPicked() {
        subject.onNext(type);
        subject.onCompleted();

        clearSubscriptions();
    }

}
