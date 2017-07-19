package com.geovanni.starwars.app.Bussiness.Utils;

import com.geovanni.starwars.app.Bussiness.Model.ErrorResponse;
import com.geovanni.starwars.app.Bussiness.Model.ErrorResponseList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by gabri on 18/07/2017.
 */

public class JsonManager {

    public static JSONObject madeJson(String key, JSONObject json) {
        JSONObject deepJson = new JSONObject();
        try {
            deepJson.put(key, json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return deepJson;
    }

    public static JSONObject madeJsonFromObject(Object oRequest) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String tmp = gson.toJson(oRequest);

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject = new JSONObject(tmp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;

    }

    public static Object jsonToObject(String json, Type type) {

        Object o = null;
        try {
            o = new GsonBuilder()
                    .setDateFormat("dd-MM-yyyy HH:mm:ss")
                    .create().
                            fromJson(json, type);

        } catch (JsonSyntaxException eSyntax) {

            try {
                o = new GsonBuilder()
                        .setDateFormat("dd-MM-yyyy HH:mm:ss")
                        .create().
                                fromJson(json, ErrorResponse.class);
            } catch (JsonSyntaxException eSyntax2) {
                o = new GsonBuilder()
                        .setDateFormat("dd-MM-yyyy HH:mm:ss")
                        .create().
                                fromJson(json, ErrorResponseList.class);
            }


        } catch (Exception e) {
            o = null;
        }
        return o;
    }
}
