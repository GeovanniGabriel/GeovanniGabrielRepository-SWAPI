package com.geovanni.starwars.app.Bussiness.Model;

import java.util.List;

/**
 * Created by gabri on 24/07/2017.
 */

public class StarshipsResponse {
    private List<Starships> results;

    public StarshipsResponse() {
    }

    public List<Starships> getResults() {
        return results;
    }

    public void setResults(List<Starships> results) {
        this.results = results;
    }
}
