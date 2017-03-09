package com.u.teach.presenter.home.cards;

import android.support.annotation.NonNull;
import com.u.teach.contract.home.cards.ProfessorCardContract;
import com.u.teach.list.adapter.GenericAdapter;
import com.u.teach.model.entity.Professor;

/**
 * Created by saguilera on 3/9/17.
 */

public class ProfessorCardPresenter extends GenericAdapter.ItemPresenter<ProfessorCardContract.View>
        implements ProfessorCardContract.Presenter {

    private @NonNull Professor professor;

    public ProfessorCardPresenter(@NonNull Professor professor) {
        this.professor = professor;
    }

    @Override
    protected void onAttach(@NonNull final ProfessorCardContract.View view) {
        view.setImage(professor.picture().medium());
        view.setName(professor.name());
        view.setTags(professor.tags());
        // TODO Coordinators.bind -> ratingView
        // TODO Coordinators.bind -> expertiseView
    }

}
