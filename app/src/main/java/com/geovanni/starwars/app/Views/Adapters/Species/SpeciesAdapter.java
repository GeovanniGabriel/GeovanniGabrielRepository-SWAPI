package com.geovanni.starwars.app.Views.Adapters.Species;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Species;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 24/07/2017.
 */

public class SpeciesAdapter extends RecyclerView.Adapter<ViewHolderItem> {

    private List<Species> speciesItems;
    private IItemListener itemListener;

    public SpeciesAdapter(IItemListener itemListener) {
        this.itemListener = itemListener;
        speciesItems = new ArrayList<>();
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new SpeciesViewHolder(layoutInflater.inflate(R.layout.item_species_row, parent, false), itemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.bindItem(speciesItems.get(position));
    }

    @Override
    public int getItemCount() {
        return speciesItems.size();
    }

    public void replaceData(List<Species> filmItems) {
        if (filmItems != null) {
            this.speciesItems = filmItems;
        }
        notifyDataSetChanged();
    }
}
