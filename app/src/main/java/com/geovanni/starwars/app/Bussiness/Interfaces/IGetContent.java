package com.geovanni.starwars.app.Bussiness.Interfaces;

/**
 * Created by gabri on 16/07/2017.
 */

public interface IGetContent<T> {

    void showProgress();

    void hideProgress();

    void showError(Throwable throwable);

    void showContent(T content);
}

