package com.geovanni.starwars.app.Bussiness.WSCaller;

import java.io.Serializable;

/**
 * Created by gabri on 18/07/2017.
 */

public class DataSourceResult implements Serializable {

    protected Object data;

    public DataSourceResult(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
