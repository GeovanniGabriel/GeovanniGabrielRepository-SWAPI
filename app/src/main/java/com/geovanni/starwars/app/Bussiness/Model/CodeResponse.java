package com.geovanni.starwars.app.Bussiness.Model;

import java.io.Serializable;

/**
 * Created by gabri on 18/07/2017.
 */

public class CodeResponse implements Serializable {

    private int code = 0;

    public CodeResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
