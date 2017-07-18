package com.geovanni.starwars.app.Bussiness.Interfaces;

/**
 * Created by gabri on 17/07/2017.
 */

public interface IWSRequestResult<T> {

    void onSuccess(T object);

    void onFailed(Throwable throwable);
}
