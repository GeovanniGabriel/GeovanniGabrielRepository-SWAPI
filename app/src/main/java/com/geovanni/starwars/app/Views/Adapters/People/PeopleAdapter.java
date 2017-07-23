package com.geovanni.starwars.app.Views.Adapters.People;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Model.People;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Base.ViewHolderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 23/07/2017.
 */

public class PeopleAdapter extends RecyclerView.Adapter<ViewHolderItem> {

    private List<People> peopleItems;
    private IItemListener itemListener;

    public PeopleAdapter(IItemListener itemListener) {
        this.itemListener = itemListener;
        peopleItems = new ArrayList<>();
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new PeopleViewHolder(layoutInflater.inflate(R.layout.item_people_row, parent, false), itemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.bindItem(peopleItems.get(position));
    }

    @Override
    public int getItemCount() {
        return peopleItems.size();
    }

    public void replaceData(List<People> filmItems) {
        if (filmItems != null) {
            this.peopleItems = filmItems;
        }
        notifyDataSetChanged();
    }
}
