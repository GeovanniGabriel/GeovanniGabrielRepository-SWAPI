package com.geovanni.starwars.app.Bussiness.Interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by gabri on 17/07/2017.
 */

public interface IBaseFragmentListener {
    void onFragmentAction(Fragment fragment, int action, Object... params);
}
