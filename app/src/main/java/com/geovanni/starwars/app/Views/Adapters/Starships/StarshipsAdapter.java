package com.geovanni.starwars.app.Views.Adapters.Starships;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Starships;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 24/07/2017.
 */

public class StarshipsAdapter extends RecyclerView.Adapter<ViewHolderItem> {

    private List<Starships> starshipsItems;
    private IItemListener itemListener;

    public StarshipsAdapter(IItemListener itemListener) {
        this.itemListener = itemListener;
        starshipsItems = new ArrayList<>();
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new StarshipViewHolder(layoutInflater.inflate(R.layout.item_starship_row, parent, false), itemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.bindItem(starshipsItems.get(position));
    }

    @Override
    public int getItemCount() {
        return starshipsItems.size();
    }

    public void replaceData(List<Starships> starshipsItems) {
        if (starshipsItems != null) {
            this.starshipsItems = starshipsItems;
        }
        notifyDataSetChanged();
    }
}
