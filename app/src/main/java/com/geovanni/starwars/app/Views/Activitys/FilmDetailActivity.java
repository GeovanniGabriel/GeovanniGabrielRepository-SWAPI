package com.geovanni.starwars.app.Views.Activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IProgressLayout;
import com.geovanni.starwars.app.Bussiness.Interfaces.IToolbarListener;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Base.BaseActivity;
import com.geovanni.starwars.app.Views.Base.BaseFragment;
import com.geovanni.starwars.app.Views.CustomViews.ProgressLayout;
import com.geovanni.starwars.app.Views.Fragments.FilmDetailFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gabri on 24/07/2017.
 */

public class FilmDetailActivity extends BaseActivity implements IProgressLayout, IToolbarListener {

    @BindView(R.id.txtTitleBar)
    TextView txtTitleBar;

    @BindView(R.id.imgToolbar)
    ImageView imgToolbar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private BaseFragment baseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);
        ButterKnife.bind(this);
        setupToolbar();

        String url = "";
        if (getIntent() != null) {
            url = getIntent().getStringExtra("_Film");
        }

        loadFragment(FilmDetailFragment.newInstance(url), FilmDetailFragment.TAG);
    }

    public void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            toolbar.setBackgroundResource(R.color.colorToolBar);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                        getSupportFragmentManager().popBackStack();
                    } else {
                        finish();
                    }
                }
            });
        }
    }

    public void loadFragment(Fragment fragment, String fragmentTag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_films, fragment, fragmentTag)
                .commit();

        if (fragment instanceof BaseFragment) {
            baseFragment = (BaseFragment) fragment;
        }
    }

    @Override
    public ProgressLayout getProgress() {
        return getProgressLayout();
    }

    @Override
    public void updateToolbar(String title, IToolbarListener.ToolbarSettings settings, String tag) {

        if (title.equals("")) {
            imgToolbar.setVisibility(View.VISIBLE);
            txtTitleBar.setVisibility(View.INVISIBLE);
        } else {
            imgToolbar.setVisibility(View.INVISIBLE);
            txtTitleBar.setVisibility(View.VISIBLE);
            txtTitleBar.setText(title);
        }
        invalidateOptionsMenu();
    }
}
