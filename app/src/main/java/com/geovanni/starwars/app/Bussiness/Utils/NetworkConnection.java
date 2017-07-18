package com.geovanni.starwars.app.Bussiness.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.geovanni.starwars.app.StarWarsApp;

/**
 * Created by gabri on 17/07/2017.
 */

public class NetworkConnection {
    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;

    private static Context context = StarWarsApp.getContext();

    /*Método para validar si se tiene conectividad*/
    public static boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    /*Método para obtener el tipo de conexión que se tiene*/
    public static int getConnectivityStatus(Context context) {

        try {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if (null != activeNetwork) {
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                    return TYPE_WIFI;

                if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                    return TYPE_MOBILE;
            }

        } catch (Exception e) {

        }

        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context) {
        int conn = NetworkConnection.getConnectivityStatus(context);
        String status = null;
        if (conn == NetworkConnection.TYPE_WIFI) {
            status = "WiFi";
        } else if (conn == NetworkConnection.TYPE_MOBILE) {
            status = "3G";
        } else if (conn == NetworkConnection.TYPE_NOT_CONNECTED) {
            status = "";
        }
        return status;
    }
}
