package com.geovanni.starwars.app.Bussiness.Model;

/**
 * Created by gabri on 16/07/2017.
 */

public class MenuItem {
    private int type;
    private String name;
    private String detail;
    private int menuTag;

    public MenuItem() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public int getMenuTag() {
        return menuTag;
    }

    public void setMenuTag(int menuTag) {
        this.menuTag = menuTag;
    }
}
