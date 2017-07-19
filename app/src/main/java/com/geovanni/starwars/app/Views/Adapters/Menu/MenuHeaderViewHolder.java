package com.geovanni.starwars.app.Views.Adapters.Menu;

import android.content.Context;
import android.view.View;

import com.geovanni.starwars.app.Bussiness.Model.MenuItem;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

/**
 * Created by gabri on 18/07/2017.
 */

public class MenuHeaderViewHolder extends ViewHolderItem<MenuItem> {

    private Context context;

    public MenuHeaderViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }
}
