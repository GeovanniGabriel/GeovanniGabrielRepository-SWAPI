package com.geovanni.starwars.app.Bussiness.Model;

import java.util.List;

/**
 * Created by gabri on 24/07/2017.
 */

public class SpeciesResponse {

    private List<Species> results;

    public SpeciesResponse() {
    }

    public List<Species> getResults() {
        return results;
    }

    public void setResults(List<Species> results) {
        this.results = results;
    }
}
