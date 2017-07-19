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
import com.geovanni.starwars.app.Bussiness.Model.RootResponse;
import com.geovanni.starwars.app.Bussiness.Presenters.RootPresenter;
import com.geovanni.starwars.app.Bussiness.Utils.Alerts;
import com.geovanni.starwars.app.Bussiness.WSCaller.DataSourceResult;
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
    private RootPresenter rootPresenter;

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

        rootPresenter = new RootPresenter(getCurrentContext(), this);
        menuAdapter = new MenuAdapter(this);
        menuItems = new ArrayList<>();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupMenuRecyclerView();
    }

    @Override
    public void onResume() {
        super.onResume();
        rootPresenter.getRoots();
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
        Alerts.showAlertMessage(getCurrentContext(), throwable.getMessage());
    }

    @Override
    public void showContent(Object content) {
        DataSourceResult response = (DataSourceResult) content;
        RootResponse rootData = (RootResponse) response.getData();
        menuItems = loadMenuItems(rootData);
        menuAdapter.replaceData(menuItems);
    }

    @Override
    public void onItemSelect(Object item, int action, int position) {

    }

    private List<MenuItem> loadMenuItems(final RootResponse data) {

        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem() {
            {
                setName("Header");
                setType(MenuItem.HEADER);
            }
        });

        if (data != null) {
            if (data.getPeople() != null) {
                menuItems.add(new MenuItem() {
                    {
                        setName("People");
                        setDetail(data.getPeople());
                        setType(MenuItem.SIMPLE_MENU);
                    }
                });
            }
            if (data.getPlanets() != null) {
                menuItems.add(new MenuItem() {
                    {
                        setName("Planets");
                        setDetail(data.getPlanets());
                        setType(MenuItem.SIMPLE_MENU);
                    }
                });
            }
            if (data.getFilms() != null) {
                menuItems.add(new MenuItem() {
                    {
                        setName("Films");
                        setDetail(data.getFilms());
                        setType(MenuItem.SIMPLE_MENU);
                    }
                });
            }
            if (data.getSpecies() != null) {
                menuItems.add(new MenuItem() {
                    {
                        setName("Species");
                        setDetail(data.getSpecies());
                        setType(MenuItem.SIMPLE_MENU);
                    }
                });
            }
            if (data.getVehicles() != null) {
                menuItems.add(new MenuItem() {
                    {
                        setName("People");
                        setDetail(data.getVehicles());
                        setType(MenuItem.SIMPLE_MENU);
                    }
                });
            }
            if (data.getStarships() != null) {
                menuItems.add(new MenuItem() {
                    {
                        setName("Starships");
                        setDetail(data.getStarships());
                        setType(MenuItem.SIMPLE_MENU);
                    }
                });
            }
        }

        return menuItems;
    }
}
