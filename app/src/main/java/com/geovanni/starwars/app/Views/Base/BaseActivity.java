package com.geovanni.starwars.app.Views.Base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.CustomViews.ProgressLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gabri on 17/07/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initViews() {
        ButterKnife.bind(this);
    }

    protected ProgressLayout getProgressLayout() {
        return progressLayout;
    }
}
