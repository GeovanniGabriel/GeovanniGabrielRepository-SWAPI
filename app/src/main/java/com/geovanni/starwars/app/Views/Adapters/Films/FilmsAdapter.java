package com.geovanni.starwars.app.Views.Adapters.Films;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Films;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 20/07/2017.
 */

public class FilmsAdapter extends RecyclerView.Adapter<ViewHolderItem> {

    private List<Films> filmItems;
    private IItemListener itemListener;

    public FilmsAdapter(IItemListener itemListener) {
        this.itemListener = itemListener;
        filmItems = new ArrayList<>();
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new FilmViewHolder(layoutInflater.inflate(R.layout.item_film_row, parent, false), itemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.bindItem(filmItems.get(position));
    }

    @Override
    public int getItemCount() {
        return filmItems.size();
    }

    public void replaceData(List<Films> filmItems) {
        if (filmItems != null) {
            this.filmItems = filmItems;
        }
        notifyDataSetChanged();
    }
}
