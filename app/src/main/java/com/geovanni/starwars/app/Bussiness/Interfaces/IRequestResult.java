package com.geovanni.starwars.app.Bussiness.Interfaces;

/**
 * Created by gabri on 17/07/2017.
 */

public interface IRequestResult<Data> {

    public void onSuccess(Data data);

    public void onFailed(Data error);
}

