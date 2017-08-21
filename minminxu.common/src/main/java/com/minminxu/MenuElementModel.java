package com.minminxu;

import java.util.LinkedList;

public class MenuElementModel {

    private String name;
    private String path;
    private MenuViewModel childs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MenuViewModel getChilds() {
        return childs;
    }

    public void setChilds(MenuViewModel childs) {
        this.childs = childs;
    }
}