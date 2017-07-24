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
import com.geovanni.starwars.app.Bussiness.Model.Starships;
import com.geovanni.starwars.app.Bussiness.Model.StarshipsResponse;
import com.geovanni.starwars.app.Bussiness.Presenters.FilmsPresenter;
import com.geovanni.starwars.app.Bussiness.Utils.Alerts;
import com.geovanni.starwars.app.Bussiness.WSCaller.DataSourceResult;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Starships.StarshipsAdapter;
import com.geovanni.starwars.app.Views.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by gabri on 24/07/2017.
 */

public class StarshipsFragment extends BaseFragment implements IItemListener, IGetContent {

    public static final String TAG = StarshipsFragment.class.getSimpleName();

    private IProgressLayout iProgressLayout;
    private FilmsPresenter starshipsPresenter;
    private StarshipsAdapter starshipsAdapter;
    private String urlStarships;
    private List<Starships> starshipItems;

    @BindView(R.id.recycler_starships)
    RecyclerView starshipsRecyclerView;

    public StarshipsFragment() {
    }

    public static StarshipsFragment newInstance() {
        StarshipsFragment fragment = new StarshipsFragment();
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
        starshipsPresenter = new FilmsPresenter(getCurrentContext(), this);
        starshipsAdapter = new StarshipsAdapter(this);
        starshipItems = new ArrayList<>();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        urlStarships = getArguments().getString("urlRootDetail");
    }

    @Override
    public void onResume() {
        super.onResume();
        showToolbarDefaultMode();
        setupMenuRecyclerView();
        starshipsPresenter.getStarships(urlStarships);
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
        StarshipsResponse starshipsData = (StarshipsResponse) response.getData();
        starshipItems = starshipsData.getResults();
        starshipsAdapter.replaceData(starshipItems);
    }

    @Override
    public void onItemSelect(Object item, int action, int position) {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_starships;
    }

    @Override
    protected String getCustomTag() {
        return TAG;
    }

    private void setupMenuRecyclerView() {
        starshipsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        starshipsRecyclerView.setAdapter(starshipsAdapter);
    }

    private void showToolbarDefaultMode() {
        updateToolbar(getString(R.string.starships));
    }
}
