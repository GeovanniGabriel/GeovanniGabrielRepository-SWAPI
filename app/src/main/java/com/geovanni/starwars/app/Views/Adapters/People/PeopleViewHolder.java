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

    public PeopleViewHolder(View itemView, IItemListener callback) {
        super(itemView);
        adapterCallback = callback;
        namePeopleTextView = (TextView) itemView.findViewById(R.id.txtNamePeople);
    }

    @Override
    public void bindItem(People item) {
        super.bindItem(item);
        namePeopleTextView.setText(item.getName());
    }
}
