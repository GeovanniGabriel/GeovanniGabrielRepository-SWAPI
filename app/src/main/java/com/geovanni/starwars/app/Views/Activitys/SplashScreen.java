package com.geovanni.starwars.app.Views.Activitys;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.geovanni.starwars.app.Bussiness.Utils.NavigationUtil;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.StarWarsApp;

/**
 * Created by gabri on 16/07/2017.
 */

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        initApp();
    }

    public void initApp() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                NavigationUtil.openActivity(SplashScreen.this, MainActivity.class);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
