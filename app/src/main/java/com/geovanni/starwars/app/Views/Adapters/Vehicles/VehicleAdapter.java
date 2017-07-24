package com.geovanni.starwars.app.Views.Adapters.Vehicles;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Vehicles;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 24/07/2017.
 */

public class VehicleAdapter extends RecyclerView.Adapter<ViewHolderItem> {

    private List<Vehicles> vehicleItems;
    private IItemListener itemListener;

    public VehicleAdapter(IItemListener itemListener) {
        this.itemListener = itemListener;
        vehicleItems = new ArrayList<>();
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new VehicleViewHolder(layoutInflater.inflate(R.layout.item_vehicle_row, parent, false), itemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.bindItem(vehicleItems.get(position));
    }

    @Override
    public int getItemCount() {
        return vehicleItems.size();
    }

    public void replaceData(List<Vehicles> vehicleItems) {
        if (vehicleItems != null) {
            this.vehicleItems = vehicleItems;
        }
        notifyDataSetChanged();
    }
}
