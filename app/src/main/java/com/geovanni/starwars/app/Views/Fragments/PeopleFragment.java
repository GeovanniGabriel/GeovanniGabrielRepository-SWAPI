package com.geovanni.starwars.app.Views.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geovanni.starwars.app.Bussiness.Interfaces.IGetContent;
import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Interfaces.IProgressLayout;
import com.geovanni.starwars.app.Bussiness.Model.People;
import com.geovanni.starwars.app.Bussiness.Model.PeopleResponse;
import com.geovanni.starwars.app.Bussiness.Presenters.FilmsPresenter;
import com.geovanni.starwars.app.Bussiness.Utils.Alerts;
import com.geovanni.starwars.app.Bussiness.WSCaller.DataSourceResult;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.People.PeopleAdapter;
import com.geovanni.starwars.app.Views.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by gabri on 23/07/2017.
 */

public class PeopleFragment extends BaseFragment implements IItemListener, IGetContent {

    public static final String TAG = PeopleFragment.class.getSimpleName();

    private FilmsPresenter peoplePresenter;
    private PeopleAdapter peopleAdapter;
    private List<People> peopleItems;
    private String urlPeople;
    private IProgressLayout iProgressLayout;

    @BindView(R.id.recycler_films)
    RecyclerView menuRecyclerView;

    public PeopleFragment() {
    }

    public static PeopleFragment newInstance() {
        PeopleFragment fragment = new PeopleFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        iProgressLayout = (IProgressLayout) activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        peoplePresenter = new FilmsPresenter(getCurrentContext(), this);
        peopleAdapter = new PeopleAdapter(this);
        peopleItems = new ArrayList<>();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        urlPeople = getArguments().getString("urlRootDetail");
    }

    @Override
    public void onResume() {
        super.onResume();
        showToolbarDefaultMode();
        setupMenuRecyclerView();
        peoplePresenter.getPeople(urlPeople);
    }

    @Override
    public void showProgress() {
        iProgressLayout.getProgress().setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        iProgressLayout.getProgress().setVisibility(View.GONE);
    }

    @Override
    public void showError(Throwable throwable) {
        Alerts.showAlertMessage(getCurrentContext(), throwable.getMessage());
    }

    @Override
    public void showContent(Object content) {
        DataSourceResult response = (DataSourceResult) content;
        PeopleResponse peopleData = (PeopleResponse) response.getData();
        peopleItems = peopleData.getResults();
        peopleAdapter.replaceData(peopleItems);
    }

    private void setupMenuRecyclerView() {
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        menuRecyclerView.setAdapter(peopleAdapter);
    }

    @Override
    public void onItemSelect(Object item, int action, int position) {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_people;
    }

    @Override
    protected String getCustomTag() {
        return null;
    }

    private void showToolbarDefaultMode() {
        updateToolbar(getString(R.string.people));
    }
}
