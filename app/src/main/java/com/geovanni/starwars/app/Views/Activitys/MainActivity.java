package com.geovanni.starwars.app.Views.Activitys;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IChangeFragments;
import com.geovanni.starwars.app.Bussiness.Interfaces.IToolbarListener;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Base.BaseActivity;
import com.geovanni.starwars.app.Views.Base.BaseFragment;
import com.geovanni.starwars.app.Views.Fragments.HomeFragment;
import com.geovanni.starwars.app.Views.Fragments.ListMenuFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IChangeFragments, IToolbarListener {

    private ListMenuFragment mFragmentMenu;
    private String currentFragmentTag;
    private BaseFragment baseFragment;
    private ActionBarDrawerToggle drawerToggle;

    @BindView(R.id.drawerMainlayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.layoutFeed)
    RelativeLayout layoutFragments;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.txtTitleBar)
    TextView txtTitleBar;

    @BindView(R.id.imgToolbar)
    ImageView imgToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupToolbar();

        mFragmentMenu = (ListMenuFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMenu);
        mFragmentMenu.setChangeFragments(this);

        setupViews();

        replaceMainFragment(HomeFragment.newInstance(), getString(R.string.start), HomeFragment.TAG, null, false);
    }

    @Override
    public void replaceMainFragment(Fragment fragment, String titleFragment, String tagFragment, String args, boolean addToBackStack) {
        drawerLayout.closeDrawer(Gravity.LEFT);

        if (tagFragment.equals(currentFragmentTag)) {
            return;
        }

        if (args != null) {
            Bundle bundle = new Bundle();
            bundle.putString("urlFilms", args);
            fragment.setArguments(bundle);
        }

        currentFragmentTag = tagFragment;

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(layoutFragments.getId(), fragment, tagFragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.toString());
        }

        fragmentTransaction.commit();

        if (fragment instanceof BaseFragment) {
            baseFragment = (BaseFragment) fragment;
        }
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    private void setupViews() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        drawerToggle.setDrawerIndicatorEnabled(false);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_menu, getTheme());
        drawerToggle.setHomeAsUpIndicator(drawable);
        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public void updateToolbar(String title, ToolbarSettings settings, String tag) {
        imgToolbar.setVisibility(View.INVISIBLE);
        txtTitleBar.setText(title);
        invalidateOptionsMenu();
    }

    private void setupToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }
}
