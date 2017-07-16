package com.geovanni.starwars.app.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.geovanni.starwars.app.Bussiness.Interfaces.IGetContent;
import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.MenuItem;
import com.geovanni.starwars.app.Views.Adapters.Menu.MenuAdapter;
import com.geovanni.starwars.app.Views.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 16/07/2017.
 */

public class ListMenuFragment extends BaseFragment implements IItemListener, IGetContent {

    private MenuAdapter menuAdapter;
    private List<MenuItem> menuItems;

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
}
