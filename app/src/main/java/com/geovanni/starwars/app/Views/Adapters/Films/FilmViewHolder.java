package com.geovanni.starwars.app.Views.Adapters.Films;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.Films;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

/**
 * Created by gabri on 21/07/2017.
 */

public class FilmViewHolder extends ViewHolderItem<Films> implements View.OnClickListener {

    private TextView nameFilmTextView;
    private TextView descriptionTextView;
    private LinearLayout containerFilm;

    public FilmViewHolder(View itemView, IItemListener callback) {
        super(itemView);
        adapterCallback = callback;
        nameFilmTextView = (TextView) itemView.findViewById(R.id.txtNameFilm);
        descriptionTextView = (TextView) itemView.findViewById(R.id.txtDescription);
        containerFilm = (LinearLayout) itemView.findViewById(R.id.containerFilm);
        containerFilm.setOnClickListener(this);
    }

    @Override
    public void bindItem(Films item) {
        super.bindItem(item);

        nameFilmTextView.setText(item.getTitle());
        descriptionTextView.setText(item.getOpening_crawl());
    }

    @Override
    public void onClick(View view) {
        if (adapterCallback != null) {
            adapterCallback.onItemSelect(getItem(), 0, getLayoutPosition());
        }
    }
}
