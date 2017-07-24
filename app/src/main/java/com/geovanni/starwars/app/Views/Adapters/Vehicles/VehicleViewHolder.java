package com.geovanni.starwars.app.Views.Adapters.Vehicles;

import android.view.View;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Vehicles;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

/**
 * Created by gabri on 24/07/2017.
 */

public class VehicleViewHolder extends ViewHolderItem<Vehicles> {

    private TextView nameVehicleTextView;
    private TextView modelTextView;
    private TextView passengerTextView;

    public VehicleViewHolder(View itemView, IItemListener callback) {
        super(itemView);
        adapterCallback = callback;

        nameVehicleTextView = (TextView) itemView.findViewById(R.id.txtNameVehicle);
        modelTextView = (TextView) itemView.findViewById(R.id.txtModel);
        passengerTextView = (TextView) itemView.findViewById(R.id.txtPassengers);
    }

    @Override
    public void bindItem(Vehicles item) {
        super.bindItem(item);

        nameVehicleTextView.setText(item.getName());
        modelTextView.setText("Model: " + item.getModel());
        passengerTextView.setText("Passengers: " + item.getPassengers());
    }
}
