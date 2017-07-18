package com.geovanni.starwars.app.Bussiness.WSCaller;

import android.content.Context;

import com.android.volley.Request;
import com.geovanni.starwars.app.Bussiness.Interfaces.IWSRequestResult;
import com.geovanni.starwars.app.Bussiness.Model.WsRequest;
import com.geovanni.starwars.app.Bussiness.Utils.Enums;
import com.geovanni.starwars.app.Bussiness.Utils.NetworkConnection;
import com.geovanni.starwars.app.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by gabri on 17/07/2017.
 */

public class WebServicesFacade {

    private Context context;
    private String connectionError = "No hay conexión de internet disponible";

    public WebServicesFacade(Context context) {
        this.context = context;
    }

    public void consumeWS(Enums method, String urlService, HashMap<String, Object> params, IWSRequestResult requestResult) {
        if (NetworkConnection.isOnline()) {
            WSCaller wsCaller = new WSCaller();
            wsCaller.doRequestWS(createRequest(method, urlService, params, requestResult));
        } else {
            requestResult.onFailed(new Exception(context != null ? context.getString(R.string.error_internet) : connectionError));
        }
    }

    private WsRequest createRequest(Enums method, String urlService, HashMap<String, Object> params, IWSRequestResult requestResult) {

        WsRequest request = new WsRequest();
        request.setMethod(getMethodType(method));
        request.set_url_request(urlService);
        request.setBody(params == null ? null : createParams(params));
        request.setRequestResult(requestResult);

        request.setTimeOut(15000);

        return request;
    }

    private int getMethodType(Enums method) {
        switch (method) {
            case METHOD_GET:
                return Request.Method.GET;
            case METHOD_POST:
                return Request.Method.POST;
        }

        return 0;
    }

    private JSONObject createParams(HashMap<String, Object> paramsMap) {

        JSONObject params = new JSONObject();

        try {

            for (String paramKey : paramsMap.keySet())
                params.put(paramKey, paramsMap.get(paramKey));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return params;

    }
}
