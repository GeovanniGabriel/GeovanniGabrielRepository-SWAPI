package com.geovanni.starwars.app.Views.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geovanni.starwars.app.Bussiness.Interfaces.IGetContent;
import com.geovanni.starwars.app.Bussiness.Interfaces.IItemListener;
import com.geovanni.starwars.app.Bussiness.Interfaces.IProgressLayout;
import com.geovanni.starwars.app.Bussiness.Model.Vehicles;
import com.geovanni.starwars.app.Bussiness.Model.VehiclesResponse;
import com.geovanni.starwars.app.Bussiness.Presenters.FilmsPresenter;
import com.geovanni.starwars.app.Bussiness.Utils.Alerts;
import com.geovanni.starwars.app.Bussiness.WSCaller.DataSourceResult;
import com.geovanni.starwars.app.R;
import com.geovanni.starwars.app.Views.Adapters.Vehicles.VehicleAdapter;
import com.geovanni.starwars.app.Views.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by gabri on 24/07/2017.
 */

public class VehiclesFragment extends BaseFragment implements IItemListener, IGetContent {
    public static final String TAG = VehiclesFragment.class.getSimpleName();

    private IProgressLayout iProgressLayout;
    private FilmsPresenter vehiclesPresenter;
    private String urlVehicles;
    private List<Vehicles> vehicleItems;
    private VehicleAdapter vehicleAdapter;

    @BindView(R.id.recycler_vehicles)
    RecyclerView vehiclesRecyclerView;

    public VehiclesFragment() {
    }

    public static VehiclesFragment newInstance() {
        VehiclesFragment fragment = new VehiclesFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        iProgressLayout = (IProgressLayout) activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vehiclesPresenter = new FilmsPresenter(getCurrentContext(), this);
        vehicleAdapter = new VehicleAdapter(this);
        vehicleItems = new ArrayList<>();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        urlVehicles = getArguments().getString("urlRootDetail");
    }

    @Override
    public void onResume() {
        super.onResume();
        showToolbarDefaultMode();
        setupRecyclerView();
        vehiclesPresenter.getVehicles(urlVehicles);
    }

    @Override
    public void showProgress() {
        iProgressLayout.getProgress().setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        iProgressLayout.getProgress().setVisibility(View.GONE);
    }

    @Override
    public void showError(Throwable throwable) {
        Alerts.showAlertMessage(getCurrentContext(), throwable.getMessage());
    }

    @Override
    public void showContent(Object content) {
        DataSourceResult response = (DataSourceResult) content;
        VehiclesResponse vehiclesData = (VehiclesResponse) response.getData();
        vehicleItems = vehiclesData.getResults();
        vehicleAdapter.replaceData(vehicleItems);
    }

    @Override
    public void onItemSelect(Object item, int action, int position) {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_vehicles;
    }

    @Override
    protected String getCustomTag() {
        return TAG;
    }

    private void setupRecyclerView() {
        vehiclesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        vehiclesRecyclerView.setAdapter(vehicleAdapter);
    }

    private void showToolbarDefaultMode() {
        updateToolbar(getString(R.string.vehicles));
    }
}
