package com.geovanni.starwars.app.Views.Adapters.Planets;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Planets;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 24/07/2017.
 */

public class PlanetsAdapter extends RecyclerView.Adapter<ViewHolderItem> {

    private List<Planets> planetsItems;
    private IItemListener itemListener;

    public PlanetsAdapter(IItemListener itemListener) {
        this.itemListener = itemListener;
        planetsItems = new ArrayList<>();
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new PlanetViewHolder(layoutInflater.inflate(R.layout.item_planet_row, parent, false), itemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.bindItem(planetsItems.get(position));
    }

    @Override
    public int getItemCount() {
        return planetsItems.size();
    }

    public void replaceData(List<Planets> planetsItems) {
        if (planetsItems != null) {
            this.planetsItems = planetsItems;
        }
        notifyDataSetChanged();
    }
}
