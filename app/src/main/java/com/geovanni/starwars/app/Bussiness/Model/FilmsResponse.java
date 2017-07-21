package com.geovanni.starwars.app.Bussiness.Model;

import java.io.Serializable;

/**
 * Created by gabri on 20/07/2017.
 */

public class FilmsResponse implements Serializable {

    private Film[] results;

    public Film[] getResults() {
        return results;
    }

    public void setResults(Film[] results) {
        this.results = results;
    }

}
