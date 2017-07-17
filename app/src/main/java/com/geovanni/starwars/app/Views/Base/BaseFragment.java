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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutResourceId(), container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    protected void setToolbarTitle(String title) {
        if (toolbarListener != null) {
            toolbarListener.updateToolbar(title, null, getCustomTag());
        }
    }

    protected void updateToolbar(String title) {
        if (toolbarListener != null) {
            toolbarListener.updateToolbar(title, null, getCustomTag());
        }
    }

    protected void updateToolbar(String title, IToolbarListener.ToolbarSettings settings) {
        if (toolbarListener != null && isActivityRunning()) {
            toolbarListener.updateToolbar(title, settings, getCustomTag());
        }
    }

    protected void showProgressView() {
        if (loaderView != null) {
            if (loaderMessageTextView != null) {
                loaderMessageTextView.setText("");
                loaderMessageTextView.setVisibility(View.GONE);
            }
            loaderView.setVisibility(View.VISIBLE);
        }
    }

    protected void showProgressView(String text) {
        if (loaderView != null) {
            if (loaderMessageTextView != null) {
                loaderMessageTextView.setText(text);
                loaderMessageTextView.setVisibility(View.VISIBLE);
            }
            loaderView.setVisibility(View.VISIBLE);
        }
    }

    protected void hideProgressView() {
        if (loaderView != null) {
            loaderView.setVisibility(View.GONE);
        }
    }

    public Context getCurrentContext() {
        return this.context;
    }

    protected void setCustomBackgroundResource(int resource) {
        rootView.setBackgroundResource(resource);
    }

    public void setAction(int action, Object... params) {
        executeAction(action, params);
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
