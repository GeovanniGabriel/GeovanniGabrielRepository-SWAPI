package com.geovanni.starwars.app.Bussiness.Model;

import com.geovanni.starwars.app.Bussiness.Interfaces.IRequestResult;
import com.geovanni.starwars.app.Bussiness.Interfaces.IWSRequestResult;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gabri on 17/07/2017.
 */

public class WsRequest {
    private int method;

    private Map<String, String> headers;

    private String _url_request;

    private JSONObject body;

    private IWSRequestResult requestResult;

    private int timeOut;

    private Type typeResponse;


    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public String get_url_request() {
        return _url_request;
    }

    public void set_url_request(String _url_request) {
        this._url_request = _url_request;
    }

    public JSONObject getBody() {
        return body;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }

    public IWSRequestResult getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(IWSRequestResult requestResult) {
        this.requestResult = requestResult;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Type getTypeResponse() {
        return typeResponse;
    }

    public void setTypeResponse(Type typeResponse) {
        this.typeResponse = typeResponse;
    }

}
