package com.geovanni.starwars.app.Bussiness.Model;

import java.util.List;

/**
 * Created by gabri on 24/07/2017.
 */

public class VehiclesResponse {
    private List<Vehicles> results;

    public VehiclesResponse() {
    }

    public List<Vehicles> getResults() {
        return results;
    }

    public void setResults(List<Vehicles> results) {
        this.results = results;
    }
}
