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
import android.widget.RelativeLayout;

import com.geovanni.starwars.app.Bussiness.Interfaces.IChangeFragments;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Base.BaseActivity;
import com.geovanni.starwars.app.Views.Base.BaseFragment;
import com.geovanni.starwars.app.Views.Fragments.HomeFragment;
import com.geovanni.starwars.app.Views.Fragments.ListMenuFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IChangeFragments {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFragmentMenu = (ListMenuFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMenu);
        mFragmentMenu.setChangeFragments(this);

        setupViews();

        replaceMainFragment(HomeFragment.newInstance(), getString(R.string.start), HomeFragment.TAG, false);
    }

    @Override
    public void replaceMainFragment(Fragment fragment, String titleFragment, String tagFragment, boolean addToBackStack) {
        drawerLayout.closeDrawer(Gravity.LEFT);

        if (tagFragment.equals(currentFragmentTag)) {
            return;
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

}
