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
import com.geovanni.starwars.app.Bussiness.Model.Species;
import com.geovanni.starwars.app.Bussiness.Model.SpeciesResponse;
import com.geovanni.starwars.app.Bussiness.Presenters.FilmsPresenter;
import com.geovanni.starwars.app.Bussiness.Utils.Alerts;
import com.geovanni.starwars.app.Bussiness.WSCaller.DataSourceResult;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Species.SpeciesAdapter;
import com.geovanni.starwars.app.Views.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by gabri on 24/07/2017.
 */

public class SpeciesFragment extends BaseFragment implements IItemListener, IGetContent {
    public static final String TAG = SpeciesFragment.class.getSimpleName();

    private IProgressLayout iProgressLayout;
    private String urlSpecies;
    private FilmsPresenter speciesPresenter;
    private List<Species> speciesItems;
    private SpeciesAdapter speciesAdapter;

    @BindView(R.id.recycler_species)
    RecyclerView speciesRecyclerView;

    public SpeciesFragment() {
    }

    public static SpeciesFragment newInstance() {
        SpeciesFragment fragment = new SpeciesFragment();
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

        speciesPresenter = new FilmsPresenter(getCurrentContext(), this);
        speciesAdapter = new SpeciesAdapter(this);
        speciesItems = new ArrayList<>();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        urlSpecies = getArguments().getString("urlRootDetail");
    }

    @Override
    public void onResume() {
        super.onResume();
        showToolbarDefaultMode();
        setupRecyclerView();
        speciesPresenter.getSpecies(urlSpecies);
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
        SpeciesResponse speciesData = (SpeciesResponse) response.getData();
        speciesItems = speciesData.getResults();
        speciesAdapter.replaceData(speciesItems);
    }

    @Override
    public void onItemSelect(Object item, int action, int position) {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_species;
    }

    @Override
    protected String getCustomTag() {
        return TAG;
    }

    private void showToolbarDefaultMode() {
        updateToolbar(getString(R.string.species));
    }

    private void setupRecyclerView() {
        speciesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        speciesRecyclerView.setAdapter(speciesAdapter);
    }
}
