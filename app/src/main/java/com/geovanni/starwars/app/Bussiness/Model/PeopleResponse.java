package com.geovanni.starwars.app.Bussiness.Model;

import java.util.List;

/**
 * Created by gabri on 23/07/2017.
 */

public class PeopleResponse {

    private List<People> results;

    public PeopleResponse() {
    }

    public List<People> getResults() {
        return results;
    }

    public void setResults(List<People> results) {
        this.results = results;
    }
}
