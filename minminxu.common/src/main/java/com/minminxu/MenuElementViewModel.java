package com.minminxu;

public class MenuElementViewModel extends MenuElementModel {

    private boolean childAble;
    private boolean active;

    public boolean isChildAble() {
        return childAble;
    }

    public void setChildAble(boolean childAble) {
        this.childAble = childAble;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}