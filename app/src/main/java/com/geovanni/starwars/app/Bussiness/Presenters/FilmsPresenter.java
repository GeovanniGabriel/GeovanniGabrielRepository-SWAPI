package com.geovanni.starwars.app.Bussiness.Presenters;

import android.content.Context;

import com.geovanni.starwars.app.Bussiness.Interactor.FilmsInteractor;
import com.geovanni.starwars.app.Bussiness.Interfaces.IGetContent;
import com.geovanni.starwars.app.Bussiness.Interfaces.IWSRequestResult;
import com.geovanni.starwars.app.Bussiness.Model.FilmsResponse;
import com.geovanni.starwars.app.Bussiness.Model.PeopleResponse;
import com.geovanni.starwars.app.Bussiness.Model.PlanetsResponse;
import com.geovanni.starwars.app.Bussiness.Model.StarshipsResponse;

/**
 * Created by gabri on 20/07/2017.
 */

public class FilmsPresenter implements IWSRequestResult<Object> {

    private IGetContent view;
    private FilmsInteractor filmsInteractor;

    public FilmsPresenter(Context context, IGetContent view) {
        this.view = view;
        filmsInteractor = new FilmsInteractor(context, this);
    }

    public void getFilms(String url) {
        view.showProgress();
        filmsInteractor.getData(url, FilmsResponse.class);
    }

    public void getPeople(String url) {
        view.showProgress();
        filmsInteractor.getData(url, PeopleResponse.class);
    }

    public void getPlanets(String url) {
        view.showProgress();
        filmsInteractor.getData(url, PlanetsResponse.class);
    }

    public void getStarships(String url) {
        view.showProgress();
        filmsInteractor.getData(url, StarshipsResponse.class);
    }

    @Override
    public void onSuccess(Object object) {
        view.hideProgress();
        view.showContent(object);
    }

    @Override
    public void onFailed(Throwable throwable) {
        view.hideProgress();
        view.showError(throwable);
    }
}
