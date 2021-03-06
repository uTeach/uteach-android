package com.u.teach.supplier.home.card;

import android.content.Context;
import android.support.annotation.NonNull;
import com.u.teach.utils.adapter.GenericAdapter;
import com.u.teach.model.entity.Professor;
import com.u.teach.presenter.home.cards.ProfessorCardPresenter;
import com.u.teach.view.home.cards.ProfessorCardView;

/**
 * Created by saguilera on 3/9/17.
 */
public class ProfessorCardSupplier extends GenericAdapter.ItemSupplier<ProfessorCardView> {

    public static final int PROFESSORS_PER_ROW = 2;

    private @NonNull Professor professor;

    public ProfessorCardSupplier(@NonNull Context context, @NonNull Professor professor) {
        super(context);
        this.professor = professor;
    }

    @NonNull
    @Override
    public ProfessorCardView createView() {
        return new ProfessorCardView(context());
    }

    @NonNull
    @Override
    public GenericAdapter.ItemPresenter createPresenter() {
        return new ProfessorCardPresenter(professor);
    }

    @Override
    public int spanSize() {
        return PROFESSORS_PER_ROW;
    }

    @Override
    public boolean isSameItem(@NonNull final GenericAdapter.ItemSupplier supplier) {
        return supplier.type() == type() &&
            professor.id() == ((ProfessorCardSupplier) supplier).professor.id();
    }

    @Override
    public boolean isSameContent(@NonNull final GenericAdapter.ItemSupplier supplier) {
        return isSameItem(supplier) &&
            professor.equals((((ProfessorCardSupplier) supplier).professor));
    }
}
