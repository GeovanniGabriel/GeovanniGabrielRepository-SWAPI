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
import com.geovanni.starwars.app.Bussiness.Model.Planets;
import com.geovanni.starwars.app.Bussiness.Model.PlanetsResponse;
import com.geovanni.starwars.app.Bussiness.Presenters.FilmsPresenter;
import com.geovanni.starwars.app.Bussiness.Utils.Alerts;
import com.geovanni.starwars.app.Bussiness.WSCaller.DataSourceResult;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Planets.PlanetsAdapter;
import com.geovanni.starwars.app.Views.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by gabri on 23/07/2017.
 */

public class PlanetsFragment extends BaseFragment implements IItemListener, IGetContent {

    public static final String TAG = PlanetsFragment.class.getSimpleName();

    private String urlPlanets;
    private IProgressLayout iProgressLayout;
    private FilmsPresenter planetsPresenter;
    private PlanetsAdapter planetsAdapter;
    private List<Planets> planetsItems;

    @BindView(R.id.recycler_planets)
    RecyclerView menuRecyclerView;

    public PlanetsFragment() {
    }

    public static PlanetsFragment newInstance() {
        PlanetsFragment fragment = new PlanetsFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        planetsPresenter = new FilmsPresenter(getCurrentContext(), this);
        planetsAdapter = new PlanetsAdapter(this);
        planetsItems = new ArrayList<>();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        urlPlanets = getArguments().getString("urlRootDetail");
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
    public void onResume() {
        super.onResume();
        showToolbarDefaultMode();
        setupMenuRecyclerView();
        planetsPresenter.getPlanets(urlPlanets);
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
        PlanetsResponse planetsData = (PlanetsResponse) response.getData();
        planetsItems = planetsData.getResults();
        planetsAdapter.replaceData(planetsItems);
    }

    @Override
    public void onItemSelect(Object item, int action, int position) {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_planets;
    }

    @Override
    protected String getCustomTag() {
        return TAG;
    }

    private void setupMenuRecyclerView() {
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        menuRecyclerView.setAdapter(planetsAdapter);
    }

    private void showToolbarDefaultMode() {
        updateToolbar(getString(R.string.planets));
    }
}
