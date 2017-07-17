package com.geovanni.starwars.app.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geovanni.starwars.app.Bussiness.Interfaces.IGetContent;
import com.geovanni.starwars.app.Bussiness.Interfaces.IChangeFragments;
import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.MenuItem;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Menu.MenuAdapter;
import com.geovanni.starwars.app.Views.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by gabri on 16/07/2017.
 */

public class ListMenuFragment extends BaseFragment implements IItemListener, IGetContent {

    private MenuAdapter menuAdapter;
    private List<MenuItem> menuItems;
    private IChangeFragments changeFragments;
    private View rootview;

    @BindView(R.id.recycler_menu)
    RecyclerView menuRecyclerView;

    public ListMenuFragment() {
    }

    public static ListMenuFragment newInstance() {
        ListMenuFragment fragment = new ListMenuFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        menuAdapter = new MenuAdapter(this);
        menuItems = new ArrayList<>();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupMenuRecyclerView();
        menuItems = loadMenuItems();
        menuAdapter.replaceData(menuItems);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_menu;
    }

    @Override
    protected String getCustomTag() {
        return ListMenuFragment.class.getSimpleName();
    }

    public void setChangeFragments(IChangeFragments changeFragments) {
        this.changeFragments = changeFragments;
    }

    private void setupMenuRecyclerView() {
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        menuRecyclerView.setAdapter(menuAdapter);
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

    @Override
    public void onItemSelect(Object item, int action, int position) {

    }

    private List<MenuItem> loadMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem() {
            {
                setName("Uno");
                setDetail("Uno");
            }
        });

        menuItems.add(new MenuItem() {
            {
                setName("dos");
                setDetail("dos");
            }
        });

        return menuItems;
    }
}
