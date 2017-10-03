package com.u.teach.contract.home.cards;

import android.support.annotation.NonNull;
import com.u.teach.contract.ContractPresenter;
import com.u.teach.contract.ContractView;
import com.u.teach.model.entity.Tag;
import java.util.List;

/**
 * Created by saguilera on 3/8/17.
 */
public interface ProfessorCardContract {

    interface View extends ContractView {

        void setImage(@NonNull String url);
        void setName(@NonNull String name);
        @NonNull android.view.View getExpertise(); // TODO android.view.View -> ExpertiseContract.View
        @NonNull android.view.View getRating(); // TODO android.view.View -> RatingContract.View
        void setTags(@NonNull List<Tag> tags);

    }

    interface Presenter extends ContractPresenter {

    }

}
