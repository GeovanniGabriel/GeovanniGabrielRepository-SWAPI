package com.geovanni.starwars.app.Views.Adapters.People;

import android.view.View;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.People;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

/**
 * Created by gabri on 23/07/2017.
 */

public class PeopleViewHolder extends ViewHolderItem<People> {

    private TextView namePeopleTextView;
    private TextView heightTextView;
    private TextView hairColorTextview;
    private TextView birthYearTextView;

    public PeopleViewHolder(View itemView, IItemListener callback) {
        super(itemView);
        adapterCallback = callback;
        namePeopleTextView = (TextView) itemView.findViewById(R.id.txtNamePeople);
        heightTextView = (TextView) itemView.findViewById(R.id.txtHeight);
        hairColorTextview = (TextView) itemView.findViewById(R.id.txtHairColor);
        birthYearTextView = (TextView) itemView.findViewById(R.id.txtBirthYear);
    }

    @Override
    public void bindItem(People item) {
        super.bindItem(item);
        namePeopleTextView.setText(item.getName());
        heightTextView.setText("Height: " + item.getHeight());
        hairColorTextview.setText("Hair color: " + item.getHair_color());
        birthYearTextView.setText("Birth Year: " + item.getBirth_year());
    }
}
