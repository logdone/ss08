package com.beec.ss08.entity;

import android.graphics.drawable.Drawable;

public class Category {
    String name;
    String type;
    String myImage ;

    public Category(String name,String type, String myImage) {
        this.name = name;
        this.type = type;
        this.myImage = myImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMyImage() {
        return myImage;
    }

    public void setMyImage(String myImage) {
        this.myImage = myImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
