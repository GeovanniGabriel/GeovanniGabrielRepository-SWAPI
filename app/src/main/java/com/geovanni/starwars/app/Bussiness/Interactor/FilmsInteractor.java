package com.geovanni.starwars.app.Bussiness.Interactor;

import android.content.Context;

import com.geovanni.starwars.app.Bussiness.Interfaces.IWSRequestResult;
import com.geovanni.starwars.app.Bussiness.Model.FilmsResponse;
import com.geovanni.starwars.app.Bussiness.Utils.Enums;
import com.geovanni.starwars.app.Bussiness.WSCaller.WebServicesFacade;

import java.util.HashMap;

/**
 * Created by gabri on 20/07/2017.
 */

public class FilmsInteractor {
    private Context context;
    private IWSRequestResult requestResult;
    private HashMap<String, Object> headers;

    public FilmsInteractor(Context context, IWSRequestResult requestResult) {
        this.context = context;
        this.requestResult = requestResult;
    }

    public void getFilms(String urlFilms) {
        WebServicesFacade webServicesFacade = new WebServicesFacade(context);
        webServicesFacade.consumeWS(Enums.METHOD_GET, urlFilms, headers, this.requestResult, FilmsResponse.class);
    }
}
