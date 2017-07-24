package com.geovanni.starwars.app.Views.Adapters.Species;

import android.view.View;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Species;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

/**
 * Created by gabri on 24/07/2017.
 */

public class SpeciesViewHolder extends ViewHolderItem<Species> {

    private TextView nameSpecieTextView;
    private TextView skinColorTextView;
    private TextView languajeTextView;

    public SpeciesViewHolder(View itemView, IItemListener callback) {
        super(itemView);
        adapterCallback = callback;

        nameSpecieTextView = (TextView) itemView.findViewById(R.id.txtNameSpecie);
        skinColorTextView = (TextView) itemView.findViewById(R.id.txtSkinColor);
        languajeTextView = (TextView) itemView.findViewById(R.id.txtLanguaje);
    }

    @Override
    public void bindItem(Species item) {
        super.bindItem(item);

        nameSpecieTextView.setText(item.getName());
        skinColorTextView.setText("Skin color: " + item.getSkin_colors());
        languajeTextView.setText("Language: " + item.getLanguage());

    }
}
