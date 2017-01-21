package com.u.teach.presenter.card;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.u.teach.contract.card.PickUserTypeCardContract;
import com.u.teach.model.AccessToken.UserType;
import com.u.teach.presenter.Presenter;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by saguilera on 1/21/17.
 */
public class PickUserTypeCardPresenter extends Presenter<PickUserTypeCardContract.View>
        implements PickUserTypeCardContract.Presenter {

    private UserType type;

    public PickUserTypeCardPresenter(PickUserTypeCardContract.View view) {
        super(view);
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
    public void onCardPicked() {
        switch (type) {
            case PROFESSOR:
            case STUDENT:
                //TODO
                Log.w("Card picked", type.name() + " clicked!");
                break;
        }

        clearSubscriptions();
    }

}
