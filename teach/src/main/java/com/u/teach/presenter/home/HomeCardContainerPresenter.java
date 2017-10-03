package com.u.teach.presenter.home;

import android.support.annotation.NonNull;
import com.google.gson.Gson;
import com.u.teach.contract.home.HomeCardContainerContract;
import com.u.teach.utils.adapter.GenericAdapter;
import com.u.teach.supplier.home.card.HeaderCardSupplier;
import com.u.teach.supplier.home.card.NoAccountCardSupplier;
import com.u.teach.supplier.home.card.ProfessorCardSupplier;
import com.u.teach.supplier.home.card.TrendingProfessorsCardSupplier;
import com.u.teach.model.entity.Professor;
import com.u.teach.presenter.Presenter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saguilera on 3/8/17.
 */
public class HomeCardContainerPresenter extends Presenter<HomeCardContainerContract.View>
        implements HomeCardContainerContract.Presenter {

    @Override
    protected void onAttach(@NonNull final HomeCardContainerContract.View view) {
        Professor professor = new Gson().fromJson(PROFESSOR_MOCK_STRING, Professor.class);

        List<GenericAdapter.ItemSupplier> mocks = new ArrayList<>();
        mocks.add(new HeaderCardSupplier(getContext(), "No Account View Mock"));

        mocks.add(new NoAccountCardSupplier(getContext()));

        mocks.add(new HeaderCardSupplier(getContext(), "Professor Mock"));

        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new ProfessorCardSupplier(getContext(), professor));

        mocks.add(new HeaderCardSupplier(getContext(), "Trending Professor Mock 2"));

        List<GenericAdapter.ItemSupplier> trendingMocks = new ArrayList<>();
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        trendingMocks.add(new ProfessorCardSupplier(getContext(), professor));
        mocks.add(new TrendingProfessorsCardSupplier(getContext(), trendingMocks));

        view.setData(mocks);
    }

    private static final String PROFESSOR_MOCK_STRING = "{\n" +
        "  \"id\": 1,\n" +
        "  \"name\": \"Santiago\",\n" +
        "  \"email\": \"mail@mailto.com\",\n" +
        "  \"gender\": \"male\",\n" +
        "  \"birthday\": \"2012-04-23T18:25:43.511Z\",\n" +
        "  \"picture\": {\n" +
        "    \"large\": \"santiago-picture-large\",\n" +
        "    \"medium\": null,\n" +
        "    \"thumb\": null\n" +
        "  },\n" +
        "  \"location\": {\n" +
        "    \"latitude\": -34.56,\n" +
        "    \"longitude\": 45.89\n" +
        "  },\n" +
        "  \"class_cost\": 4000,\n" +
        "  \"subjects\": [\n" +
        "    {\n" +
        "      \"id\": 2,\n" +
        "      \"name\": \"math\",\n" +
        "      \"level\": [\n" +
        "        \"high\",\n" +
        "        \"college\"\n" +
        "      ]\n" +
        "    }\n" +
        "  ],\n" +
        "  \"pending_requests\": [\n" +
        "    {\n" +
        "      \"id\": 1,\n" +
        "      \"name\": \"Santiago\",\n" +
        "      \"email\": \"mail@mailto.com\",\n" +
        "      \"gender\": \"male\",\n" +
        "      \"birthday\": \"2012-04-23T18:25:43.511Z\",\n" +
        "      \"picture\": {\n" +
        "        \"large\": \"santiago-picture-large\",\n" +
        "        \"medium\": null,\n" +
        "        \"thumb\": null\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 2,\n" +
        "      \"name\": \"Santiago\",\n" +
        "      \"email\": \"mail@mailto.com\",\n" +
        "      \"gender\": \"male\",\n" +
        "      \"birthday\": \"2012-04-23T18:25:43.511Z\",\n" +
        "      \"picture\": {\n" +
        "        \"large\": \"santiago-picture-large\",\n" +
        "        \"medium\": null,\n" +
        "        \"thumb\": null\n" +
        "      }\n" +
        "    }\n" +
        "  ],\n" +
        "  \"expertise\": {\n" +
        "    \"value\": \"black\"\n" +
        "  },\n" +
        "  \"rating\": {\n" +
        "    \"value\": \"A+\"\n" +
        "  }\n" +
        "}";

}
