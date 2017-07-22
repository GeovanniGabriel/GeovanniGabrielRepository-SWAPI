package com.geovanni.starwars.app.Bussiness.Model;

import java.util.List;

/**
 * Created by gabri on 20/07/2017.
 */

public class FilmsResponse {

    private List<Films> results;

    public FilmsResponse() {
    }

    public List<Films> getResults() {
        return results;
    }

    public void setResults(List<Films> results) {
        this.results = results;
    }

}
