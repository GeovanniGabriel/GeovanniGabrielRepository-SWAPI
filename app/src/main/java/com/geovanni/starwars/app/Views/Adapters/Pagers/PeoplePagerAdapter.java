package com.geovanni.starwars.app.Views.Adapters.Pagers;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Model.People;
import com.geovanni.starwars.app.R;

import java.util.List;

/**
 * Created by gabri on 25/07/2017.
 */

public class PeoplePagerAdapter extends PagerAdapter {

    List<People> resources;
    Context context;
    LayoutInflater layoutInflater;

    public PeoplePagerAdapter(Context context, List<People> resources) {
        this.resources = resources;
        this.context = context;
        this.layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item_pager_people, container, false);

        TextView nameTextView = (TextView) itemView.findViewById(R.id.txtNamePeople);
        nameTextView.setText(this.resources.get(position).getName());

        TextView heightTextView = (TextView) itemView.findViewById(R.id.txtHeight);
        heightTextView.setText("Height: " + this.resources.get(position).getHeight());

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return resources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }
}
