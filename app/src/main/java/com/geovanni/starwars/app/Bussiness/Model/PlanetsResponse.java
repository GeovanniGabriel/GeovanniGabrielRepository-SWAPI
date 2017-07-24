package com.geovanni.starwars.app.Bussiness.Model;

import java.util.List;

/**
 * Created by gabri on 23/07/2017.
 */

public class PlanetsResponse {

    private List<Planets> results;

    public PlanetsResponse() {
    }

    public List<Planets> getResults() {
        return results;
    }

    public void setResults(List<Planets> results) {
        this.results = results;
    }
}
