package com.minminxu;

public class PageElementViewModel extends PageElementModel {

    public int number;
    private boolean hidden;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}