package com.geovanni.starwars.app.Views.Adapters.Planets;

import android.view.View;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Planets;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

/**
 * Created by gabri on 24/07/2017.
 */

public class PlanetViewHolder extends ViewHolderItem<Planets> {

    private TextView namePlanetTextView;
    private TextView climateTextView;
    private TextView populationTextView;

    public PlanetViewHolder(View itemView, IItemListener callback) {
        super(itemView);
        adapterCallback = callback;
        namePlanetTextView = (TextView) itemView.findViewById(R.id.txtNamePlanet);
        climateTextView = (TextView) itemView.findViewById(R.id.txtClimate);
        populationTextView = (TextView) itemView.findViewById(R.id.txtPopulation);
    }

    @Override
    public void bindItem(Planets item) {
        super.bindItem(item);

        namePlanetTextView.setText(item.getName());
        climateTextView.setText("Climate: " + item.getClimate());
        populationTextView.setText("Population: " + item.getPopulation());
    }
}
