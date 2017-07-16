package com.geovanni.starwars.app.Views.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Fragments.ListMenuFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ListMenuFragment mFragmentMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFragmentMenu = (ListMenuFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMenu);
    }
}
