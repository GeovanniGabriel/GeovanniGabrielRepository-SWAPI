package com.geovanni.starwars.app.Views.Base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geovanni.starwars.app.Bussiness.Interfaces.IBaseFragmentListener;
import com.geovanni.starwars.app.Bussiness.Interfaces.IToolbarListener;
import com.geovanni.starwars.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gabri on 16/07/2017.
 */

public abstract class BaseFragment extends Fragment {

    private Context context;
    private IToolbarListener toolbarListener;
    private IBaseFragmentListener baseFragmentListener;
    private View rootView;

    @Nullable
    @BindView(R.id.layout_loader)
    View loaderView;

    @Nullable
    @BindView(R.id.textview_loader_message)
    TextView loaderMessageTextView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        try {
            toolbarListener = (IToolbarListener) context;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            if (context instanceof IBaseFragmentListener) {
                baseFragmentListener = (IBaseFragmentListener) context;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutResourceId(), container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    protected void updateToolbar(String title) {
        if (toolbarListener != null) {
            toolbarListener.updateToolbar(title, null, getCustomTag());
        }
    }

    public Context getCurrentContext() {
        return this.context;
    }

    protected void executeAction(int action, Object... params) {

    }

    protected void notifyActivityAction(Fragment fragment, int action, Object... params) {
        if (baseFragmentListener != null) {
            baseFragmentListener.onFragmentAction(fragment, action, params);
        }
    }

    protected boolean isActivityRunning() {
        return !((Activity) getCurrentContext()).isFinishing();
    }

    protected abstract int getLayoutResourceId();

    protected abstract String getCustomTag();
}
