package com.geovanni.starwars.app.Views.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.geovanni.starwars.app.Bussiness.Interfaces.IGetContent;
import com.geovanni.starwars.app.Bussiness.Interfaces.IProgressLayout;
import com.geovanni.starwars.app.Bussiness.Model.Films;
import com.geovanni.starwars.app.Bussiness.Model.People;
import com.geovanni.starwars.app.Bussiness.Presenters.FilmsPresenter;
import com.geovanni.starwars.app.Bussiness.Utils.Alerts;
import com.geovanni.starwars.app.Bussiness.WSCaller.DataSourceResult;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Base.BaseFragment;
import com.geovanni.starwars.app.Views.CustomViews.DetailFilmView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Created by gabri on 24/07/2017.
 */

public class FilmDetailFragment extends BaseFragment implements IGetContent {

    public static final String TAG = FilmDetailFragment.class.getSimpleName();

    @BindView(R.id.detail_film_view)
    DetailFilmView detailFilmView;

    private List<String> peopleUrls;
    private String urlDetail;
    private List<People> peopleList;
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
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        urlDetail = getArguments().getString("_url");
        peopleList = new ArrayList<People>();
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
        if (response.getData() instanceof Films) {
            Films filmData = (Films) response.getData();
            getDataFilm(filmData);
        } else if (response.getData() instanceof People) {
            People peopleData = (People) response.getData();
            peopleList.add(peopleData);
            if (peopleUrls.size() == peopleList.size()) {
                detailFilmView.showPeopleData(peopleList);
            }
        }
    }

    private void getDataFilm(Films film) {
        showToolbarDefaultMode(film.getTitle());
        String[] strings = film.getCharacters();
        peopleUrls = new ArrayList<String>(Arrays.asList(strings));
        detailFilmView.showData(film);

        for (String url : peopleUrls) {
            filmsPresenter.getPeopleDetail(url);
        }

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
