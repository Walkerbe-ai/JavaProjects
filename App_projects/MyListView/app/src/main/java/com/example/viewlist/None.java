package com.example.viewlist;

public class None {
    private String title;
    private String info;
    private int imageResourceId;

    public None(String title, String info, int imageResourceId){
        this.title = title;
        this.info = info;
        this.imageResourceId = imageResourceId;
    }
    public String getTitle(){return title;}
    public String getInfo(){return info;}
    public int getImageResourceId(){return imageResourceId;}

    @Override
    public String toString(){return title;}

}
