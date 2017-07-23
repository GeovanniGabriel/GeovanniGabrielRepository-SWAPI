package com.geovanni.starwars.app.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.geovanni.starwars.app.Bussiness.Interfaces.IGetContent;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Base.BaseFragment;

/**
 * Created by gabri on 17/07/2017.
 */

public class HomeFragment extends BaseFragment implements IGetContent<Object> {

    public static final String TAG = HomeFragment.class.getSimpleName();

    private View rootview;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        showToolbarDefaultMode();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_home;
    }

    @Override
    protected String getCustomTag() {
        return HomeFragment.class.getSimpleName();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void showContent(Object content) {

    }

    private void showToolbarDefaultMode() {
        updateToolbar(getString(R.string.inicio));
    }

}
