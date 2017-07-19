package com.geovanni.starwars.app.Bussiness.Model;

import java.util.List;

/**
 * Created by gabri on 18/07/2017.
 */

public class ErrorResponseList extends Response {

    private List<CodeResponse> Data;

    private ErrorResponseList() {
    }

    public List<CodeResponse> getData() {
        return Data;
    }

    public void setData(List<CodeResponse> data) {
        Data = data;
    }
}
