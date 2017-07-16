package com.geovanni.starwars.app.Views.Adapters.Base;

import android.view.View;

import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;

import android.support.v7.widget.RecyclerView;

/**
 * Created by gabri on 16/07/2017.
 */

public abstract class ViewHolderItem<T> extends RecyclerView.ViewHolder {

    private T item;
    protected IItemListener adapterCallback;
    private int mode;

    public ViewHolderItem(View itemView) {
        super(itemView);
    }

    public void bindItem(T item) {
        this.item = item;
    }

    public void bindItem(T item, int mode) {
        this.item = item;
        this.mode = mode;
    }

    public T getItem() {
        return item;
    }

    public int getMode() {
        return mode;
    }
}
