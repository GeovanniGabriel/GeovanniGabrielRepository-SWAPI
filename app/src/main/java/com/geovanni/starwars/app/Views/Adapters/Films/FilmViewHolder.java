package com.geovanni.starwars.app.Views.Adapters.Films;

import android.view.View;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Films;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

/**
 * Created by gabri on 21/07/2017.
 */

public class FilmViewHolder extends ViewHolderItem<Films> {

    private TextView nameFilmTextView;

    public FilmViewHolder(View itemView, IItemListener callback) {
        super(itemView);
        adapterCallback = callback;
        nameFilmTextView = (TextView) itemView.findViewById(R.id.txtNameFilm);
    }

    @Override
    public void bindItem(Films item) {
        super.bindItem(item);

        nameFilmTextView.setText(item.getTitle());
    }
}
