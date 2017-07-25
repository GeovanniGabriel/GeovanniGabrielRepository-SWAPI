package com.geovanni.starwars.app.Views.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.geovanni.starwars.app.Bussiness.Interfaces.IGetContent;
import com.geovanni.starwars.app.Bussiness.Interfaces.IProgressLayout;
import com.geovanni.starwars.app.Bussiness.Model.Films;
import com.geovanni.starwars.app.Bussiness.Presenters.FilmsPresenter;
import com.geovanni.starwars.app.Bussiness.Utils.Alerts;
import com.geovanni.starwars.app.Bussiness.WSCaller.DataSourceResult;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Base.BaseFragment;

/**
 * Created by gabri on 24/07/2017.
 */

public class FilmDetailFragment extends BaseFragment implements IGetContent {

    public static final String TAG = FilmDetailFragment.class.getSimpleName();

    private String urlDetail;
    private IProgressLayout iProgressLayout;
    private FilmsPresenter filmsPresenter;

    public FilmDetailFragment() {
    }

    public static FilmDetailFragment newInstance(String url) {
        FilmDetailFragment fragment = new FilmDetailFragment();

        Bundle args = new Bundle();
        args.putString("_url", url);
        fragment.setArguments(args);

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

        if (getArguments() != null) {
            urlDetail = getArguments().getString("_url");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        filmsPresenter.getFilmsDetail(urlDetail);
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
        Films filmData = (Films) response.getData();
        showToolbarDefaultMode(filmData.getTitle());
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_detail_film;
    }

    @Override
    protected String getCustomTag() {
        return TAG;
    }

    private void showToolbarDefaultMode(String title) {
        updateToolbar(title);
    }
}
