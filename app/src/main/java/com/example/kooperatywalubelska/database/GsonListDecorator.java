package com.example.kooperatywalubelska.database;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class GsonListDecorator<ElementClass> {

    @Expose
    private ArrayList<ElementClass> arrayList;

    public ArrayList<ElementClass> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<ElementClass> arrayList) {
        this.arrayList = arrayList;
    }
}
