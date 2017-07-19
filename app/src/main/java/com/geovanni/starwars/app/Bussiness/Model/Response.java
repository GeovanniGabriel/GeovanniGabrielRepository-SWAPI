package com.geovanni.starwars.app.Bussiness.Model;

import java.io.Serializable;

/**
 * Created by gabri on 18/07/2017.
 */

public class Response implements Serializable {

    private int Success;

    public Response() {
    }

    public Response(int success) {
        Success = success;
    }

    public int getSuccess() {
        return Success;
    }

    public void setSuccess(int success) {
        Success = success;
    }
}
