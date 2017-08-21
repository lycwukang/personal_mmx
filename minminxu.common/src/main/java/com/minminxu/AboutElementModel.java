package com.minminxu;

import java.util.LinkedList;

public class AboutElementModel {

    private String image;
    private LinkedList<StringModel> titles;
    private LinkedList<StringModel> descs;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LinkedList<StringModel> getTitles() {
        return titles;
    }

    public void setTitles(LinkedList<StringModel> titles) {
        this.titles = titles;
    }

    public LinkedList<StringModel> getDescs() {
        return descs;
    }

    public void setDescs(LinkedList<StringModel> descs) {
        this.descs = descs;
    }
}