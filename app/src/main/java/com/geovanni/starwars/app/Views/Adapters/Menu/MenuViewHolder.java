package com.geovanni.starwars.app.Views.Adapters.Menu;

import android.view.View;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.MenuItem;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

/**
 * Created by gabri on 16/07/2017.
 */

public class MenuViewHolder extends ViewHolderItem<MenuItem> implements View.OnClickListener {

    private TextView nameTextView;
    private TextView detailTextView;

    public MenuViewHolder(View itemView, IItemListener callback) {
        super(itemView);

        adapterCallback = callback;
        nameTextView = (TextView) itemView.findViewById(R.id.textview_name);
        detailTextView = (TextView) itemView.findViewById(R.id.textview_detail);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (adapterCallback != null) {
            adapterCallback.onItemSelect(getItem(), 0, getLayoutPosition());
        }
    }

    @Override
    public void bindItem(MenuItem item) {
        super.bindItem(item);

        nameTextView.setText(item.getName());

    }
}
