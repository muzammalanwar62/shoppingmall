package com.example.ma.lecture7;

/**
 * Created by MA on 6/30/2017.
 */

public class catorgery {
    public catorgery(String catorgeryname,int image){
        this.setCatorgeryname(catorgeryname);
        this.setImage(image);
    }
    public String getCatorgeryname() {
        return catorgeryname;
    }

    public void setCatorgeryname(String catorgeryname) {
        this.catorgeryname = catorgeryname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    String catorgeryname;
    int image;
}
