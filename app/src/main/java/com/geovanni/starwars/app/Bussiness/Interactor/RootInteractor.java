package com.geovanni.starwars.app.Bussiness.Interactor;

import android.content.Context;

import com.geovanni.starwars.app.Bussiness.Constants.Constants;
import com.geovanni.starwars.app.Bussiness.Interfaces.IWSRequestResult;
import com.geovanni.starwars.app.Bussiness.Utils.Enums;
import com.geovanni.starwars.app.Bussiness.WSCaller.WebServicesFacade;

import java.util.HashMap;

/**
 * Created by gabri on 17/07/2017.
 */

public class RootInteractor {

    private Context context;
    private IWSRequestResult requestResult;
    private HashMap<String, Object> headers;

    public RootInteractor(Context context, IWSRequestResult requestResult) {
        this.context = context;
        this.requestResult = requestResult;
    }

    public void getRoots() {
        WebServicesFacade webServicesFacade = new WebServicesFacade(context);
        webServicesFacade.consumeWS(Enums.METHOD_GET, Constants.URL_BASE, headers, this.requestResult);
    }
}
