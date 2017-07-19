package com.geovanni.starwars.app.Bussiness.Model;

/**
 * Created by gabri on 16/07/2017.
 */

public class MenuItem {

    public static final int HEADER = 0;
    public static final int SIMPLE_MENU = 1;

    private String name;
    private String detail;
    private int type;

    public MenuItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
