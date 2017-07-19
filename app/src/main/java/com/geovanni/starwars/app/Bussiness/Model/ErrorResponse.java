package com.geovanni.starwars.app.Bussiness.Model;

/**
 * Created by gabri on 18/07/2017.
 */

public class ErrorResponse extends Response {

    private CodeResponse Data;

    private ErrorResponse() {
    }

    public CodeResponse getData() {
        return Data;
    }

    public void setData(CodeResponse data) {
        Data = data;
    }
}

