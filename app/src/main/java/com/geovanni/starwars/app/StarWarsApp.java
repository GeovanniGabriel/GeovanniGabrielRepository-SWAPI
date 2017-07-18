package com.geovanni.starwars.app;

import android.app.Application;
import android.content.Context;


/**
 * Created by gabri on 17/07/2017.
 */

public class StarWarsApp extends Application {

    private static Context contextApp;
    private static StarWarsApp m_singleton;

    @Override
    public void onCreate() {
        super.onCreate();
        contextApp = this;
        m_singleton = this;
    }

    public static Context getContext() {
        return contextApp;
    }

    public static StarWarsApp getInstance() {
        return m_singleton;
    }
}
