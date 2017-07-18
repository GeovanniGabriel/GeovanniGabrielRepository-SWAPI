package com.geovanni.starwars.app.Bussiness.WSCaller;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.geovanni.starwars.app.Bussiness.Model.WsRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

import static com.geovanni.starwars.app.StarWarsApp.getContext;

/**
 * Created by gabri on 17/07/2017.
 */

public class WSCaller {

    private final String TAG = this.getClass().getName();

    /**
     * Método para realizar la petición http segun los
     * datos de la petición pasada como parámetro.
     *
     * @param request {@link WsRequest}
     */

    public void doRequestWS(final WsRequest request) {

        VolleySingleton volleySingleton = VolleySingleton.getInstance(getContext());

        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                request.getMethod(),
                request.get_url_request(),
                request.getBody(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "Request Success: " + request.get_url_request());
                        Log.d(TAG, "Response body: " + response != null ? response.toString() : "Response is null");

                        request.getRequestResult().onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Request Failed: " + error.getMessage());

                        request.getRequestResult().onFailed(handleNetworkResponse(error));
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                if (request.getHeaders() == null) {
                    return super.getHeaders();
                }
                return request.getHeaders();
            }
        };

        jsonRequest.setRetryPolicy(new DefaultRetryPolicy(request.getTimeOut(), DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getInstance(getContext()).addToRequestQueue(jsonRequest);
    }

    private Throwable handleNetworkResponse(VolleyError volleyError) {

        NetworkResponse networkResponse = volleyError.networkResponse;
        String errorMessage;

        if (networkResponse != null) {
            if (networkResponse.data != null) {
                errorMessage = parseErrorMessage(new String(networkResponse.data));
            } else {
                errorMessage = handleErrorResponse(networkResponse.statusCode);
            }

            Log.d("Response", "Response StatusCode = " + networkResponse.statusCode);
            Log.d("Response", "Response Message = " + networkResponse.data != null ? new String(networkResponse.data) : "No data response");

        } else {
            errorMessage = volleyError.getCause() != null ? volleyError.getCause().getMessage() : "Unknown error";
        }
        return new Throwable(errorMessage);
    }

    private String handleErrorResponse(int statusCode) {
        String message;

        // Error handling for error responses
        // https://developer.mozilla.org/es/docs/Web/HTTP/Status
        // ******************************
        // 4xx: Client Error responses
        // ******************************
        // Bad Request
        // Unauthorized
        // Forbidden
        // Not Found
        // Method Not Allowed
        // Request Timeout
        // Conflict
        // ******************************
        // 5×× Server Error responses
        // ******************************
        // Internal Server Error
        // Not Implemented
        // Bad Gateway
        // Service Unavailable
        switch (statusCode) {
            // Client error responses
            case 400:
                message = "Bad Request - The server could not understand the request due to invalid syntax.";
                break;
            case 401:
                message = "Unauthorized - Authentication is needed to get requested response.";
                break;
            case 403:
                message = "Forbidden - Client does not have access rights to the content so server is rejecting to give proper response.";
                break;
            case 404:
                message = "Not Found - Server can not find requested resource.";
                break;
            case 405:
                message = "Method Not Allowed - The request method is known by the server but has been disabled and cannot be used.";
                break;
            case 408:
                message = "Request Timeout - This response is sent on an idle connection by some servers, even without any previous request by the client.";
                break;
            case 409:
                message = "Conflict - This response would be sent when a request conflict with current state of server.";
                break;
            case 422:
                message = "Unprocessable Entity - The request was well-formed but was unable to be followed due to semantic errors.";
                break;

            // Server error responses
            case 500:
                message = "Internal Server Error - The server has encountered a situation it doesn't know how to handle.";
                break;
            case 501:
                message = "Not Implemented - The request method is not supported by the server and cannot be handled.";
                break;
            case 502:
                message = "Bad Gateway - The server, while working as a gateway to get a response needed to handle the request, got an invalid response.";
                break;
            case 503:
                message = "Service Unavailable - The server is not ready to handle the request.";
                break;
            default:
                message = "The specific HTTP request has been interrupted";
                break;
        }

        return message;
    }

    private String parseErrorMessage(Object errorObject) {
        String error = "";
        String errorArray = "[" + errorObject + "]";
        try {
            JSONArray jArray = new JSONArray(errorArray);
            JSONObject jObject = null;


            for (int i = 0; i < jArray.length(); i++) {
                jObject = jArray.getJSONObject(i);
                Iterator<String> keys = jObject.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    error = jObject.get(key).toString();
                }
            }
        } catch (JSONException e) {
            return "El formato de respuesta no es correcto";
        }
        return error;
    }
}
