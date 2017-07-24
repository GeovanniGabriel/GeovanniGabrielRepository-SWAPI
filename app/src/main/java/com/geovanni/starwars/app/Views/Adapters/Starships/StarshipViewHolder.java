package com.geovanni.starwars.app.Views.Adapters.Starships;

import android.view.View;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Starships;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

/**
 * Created by gabri on 24/07/2017.
 */

public class StarshipViewHolder extends ViewHolderItem<Starships> {

    private TextView nameStarshipTextView;
    private TextView modelTextView;
    private TextView passengersTextView;

    public StarshipViewHolder(View itemView, IItemListener callback) {
        super(itemView);
        adapterCallback = callback;
        nameStarshipTextView = (TextView) itemView.findViewById(R.id.txtNameStarship);
        modelTextView = (TextView) itemView.findViewById(R.id.txtModel);
        passengersTextView = (TextView) itemView.findViewById(R.id.txtPassengers);
    }

    @Override
    public void bindItem(Starships item) {
        super.bindItem(item);

        nameStarshipTextView.setText(item.getName());
        modelTextView.setText("Model: " + item.getModel());
        passengersTextView.setText("Passengers: " + item.getPassengers());
    }
}
