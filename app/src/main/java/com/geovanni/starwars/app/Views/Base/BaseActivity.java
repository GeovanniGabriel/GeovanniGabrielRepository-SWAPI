package com.geovanni.starwars.app.Views.Base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gabri on 17/07/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
