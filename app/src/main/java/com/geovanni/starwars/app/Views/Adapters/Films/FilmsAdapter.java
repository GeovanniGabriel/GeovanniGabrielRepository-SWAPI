package com.geovanni.starwars.app.Views.Adapters.Films;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.FilmItem;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

import java.util.List;

/**
 * Created by gabri on 20/07/2017.
 */

public class FilmsAdapter extends RecyclerView.Adapter<ViewHolderItem> {

    private List<FilmItem> filmItems;
    private IItemListener itemListener;

    public FilmsAdapter(IItemListener itemListener) {
        this.itemListener = itemListener;
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.bindItem(filmItems.get(position));
    }

    @Override
    public int getItemCount() {
        return filmItems.size();
    }

    public void replaceData(List<FilmItem> menuItems) {
        if (filmItems != null) {
            this.filmItems = filmItems;
        }

        notifyDataSetChanged();
    }
}
