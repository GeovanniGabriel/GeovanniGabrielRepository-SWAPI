package com.geovanni.starwars.app.Views.Base;

import android.support.v4.app.Fragment;

import com.geovanni.starwars.app.Bussiness.Interfaces.IGetContent;
import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;

/**
 * Created by gabri on 16/07/2017.
 */

public class BaseFragment extends Fragment implements IItemListener, IGetContent {

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void showContent(Object content) {

    }

    @Override
    public void onItemSelect(Object item, int action, int position) {

    }
}
