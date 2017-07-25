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
import com.geovanni.starwars.app.Bussiness.Model.Films;
import com.geovanni.starwars.app.Bussiness.Model.FilmsResponse;
import com.geovanni.starwars.app.Bussiness.Presenters.FilmsPresenter;
import com.geovanni.starwars.app.Bussiness.Utils.Alerts;
import com.geovanni.starwars.app.Bussiness.WSCaller.DataSourceResult;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Films.FilmsAdapter;
import com.geovanni.starwars.app.Views.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by gabri on 20/07/2017.
 */

public class FilmsFragment extends BaseFragment implements IItemListener, IGetContent {
    public static final String TAG = FilmsFragment.class.getSimpleName();

    private FilmsPresenter filmsPresenter;
    private FilmsAdapter filmsAdapter;
    private List<Films> filmItems;
    private String urlFilms;
    private IProgressLayout iProgressLayout;
    public static final int ACTION_SHOW_FILM = 1;

    @BindView(R.id.recycler_films)
    RecyclerView filmsRecyclerView;

    public FilmsFragment() {
    }

    public static FilmsFragment newInstance() {
        FilmsFragment fragment = new FilmsFragment();
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

        filmsPresenter = new FilmsPresenter(getCurrentContext(), this);
        filmsAdapter = new FilmsAdapter(this);
        filmItems = new ArrayList<>();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        urlFilms = getArguments().getString("urlRootDetail");
    }

    @Override
    public void onResume() {
        super.onResume();
        showToolbarDefaultMode();
        setupRecyclerView();
        filmsPresenter.getFilms(urlFilms);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_films;
    }

    @Override
    protected String getCustomTag() {
        return TAG;
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
        FilmsResponse filmsData = (FilmsResponse) response.getData();
        filmItems = filmsData.getResults();
        filmsAdapter.replaceData(filmItems);
    }

    private void setupRecyclerView() {
        filmsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        filmsRecyclerView.setAdapter(filmsAdapter);
    }

    @Override
    public void onItemSelect(Object item, int action, int position) {
        notifyActivityAction(this, ACTION_SHOW_FILM, item);
    }

    private void showToolbarDefaultMode() {
        updateToolbar(getString(R.string.films));
    }
}
