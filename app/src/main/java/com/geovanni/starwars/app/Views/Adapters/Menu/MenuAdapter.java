package com.geovanni.starwars.app.Views.Adapters.Menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.MenuItem;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 16/07/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<ViewHolderItem> {

    private List<MenuItem> menuItems;
    private IItemListener itemListener;

    public MenuAdapter(IItemListener itemListener) {
        menuItems = new ArrayList<>();
        this.itemListener = itemListener;
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (viewType == MenuItem.HEADER) {
            return new MenuHeaderViewHolder(layoutInflater.inflate(R.layout.header_menu_layout, parent, false));
        } else {
            return new MenuViewHolder(layoutInflater.inflate(R.layout.item_menu_detail, parent, false), itemListener);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.bindItem(menuItems.get(position));
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return MenuItem.HEADER;
        } else {
            return MenuItem.SIMPLE_MENU;
        }
    }

    public void replaceData(List<MenuItem> menuItems) {

        if (menuItems != null) {
            this.menuItems = menuItems;
        }

        notifyDataSetChanged();
    }
}
