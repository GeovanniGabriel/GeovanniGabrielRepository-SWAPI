package com.geovanni.starwars.app.Views.CustomViews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Model.Films;
import com.geovanni.starwars.app.Bussiness.Model.People;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Pagers.PeoplePagerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gabri on 25/07/2017.
 */

public class DetailFilmView extends LinearLayout {

    @BindView(R.id.txtDetail)
    TextView detailTextView;

    @BindView(R.id.txtDirector)
    TextView directorTextView;

    @BindView(R.id.pager)
    ViewPager pager;

    @BindView(R.id.containerPeople)
    LinearLayout containerPager;

    public DetailFilmView(Context context) {
        super(context);
        init();
    }

    public DetailFilmView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DetailFilmView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = layoutInflater.inflate(R.layout.detail_film_layout, this, true);
        ButterKnife.bind(this, rootView);

        detailTextView.setText("");
        directorTextView.setText("");

    }

    public void showData(Films film) {
        if (film == null) return;

        detailTextView.setText(film.getOpening_crawl());
        directorTextView.setText("Director: " + film.getDirector());
    }

    public void showPeopleData(List<People> people) {
        pager.setAdapter(new PeoplePagerAdapter(getContext(), people));
        pager.setVisibility(View.VISIBLE);
        containerPager.setVisibility(View.VISIBLE);

    }
}
