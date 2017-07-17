package com.geovanni.starwars.app.Bussiness.Interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by gabri on 17/07/2017.
 */

public interface IChangeFragments {
    void replaceMainFragment(Fragment fragment, String titleFragment, String tagFragment, boolean addToBackStack);
}
