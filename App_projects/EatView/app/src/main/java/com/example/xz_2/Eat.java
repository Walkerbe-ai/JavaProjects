package com.example.xz_2;

import android.graphics.Bitmap;

public class Eat {
    private String name;
    private String desctiption;
    private int eatResource;
    private Bitmap bitmap;
    public Eat(String name, String desctiption, int eatResource){

        this.name=name;
        this.desctiption=desctiption;
        this.eatResource=eatResource;
    }
    public Eat(String name, String desctiption, Bitmap bitmap){

        this.name=name;
        this.desctiption=desctiption;
        this.bitmap=bitmap;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsctiption() {
        return this.desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    public int getEatResource() {return this.eatResource; }

    public void setEatResource(int eatResource) {
        this.eatResource = eatResource;
    }
    public Bitmap getBitmap() {return this.bitmap; }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

}
