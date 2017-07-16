package com.geovanni.starwars.app.Bussiness.Interfaces;

/**
 * Created by gabri on 16/07/2017.
 */

public interface IItemListener<T> {
    void onItemSelect(T item, int action, int position);
}
