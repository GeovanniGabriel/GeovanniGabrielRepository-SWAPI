package com.geovanni.starwars.app.Bussiness.Presenters;

import android.content.Context;

import com.geovanni.starwars.app.Bussiness.Interactor.RootInteractor;
import com.geovanni.starwars.app.Bussiness.Interfaces.IGetContent;
import com.geovanni.starwars.app.Bussiness.Interfaces.IWSRequestResult;

/**
 * Created by gabri on 17/07/2017.
 */

public class RootPresenter implements IWSRequestResult<Object> {

    private IGetContent view;
    private RootInteractor rootInteractor;

    public RootPresenter(Context context, IGetContent view) {
        this.view = view;
        rootInteractor = new RootInteractor(context, this);
    }

    public void getRoots() {
        view.showProgress();
        rootInteractor.getRoots();
    }

    @Override
    public void onSuccess(Object object) {
        view.hideProgress();
        view.showContent(object);
    }

    @Override
    public void onFailed(Throwable throwable) {
        view.hideProgress();
        view.showError(throwable);
    }
}
