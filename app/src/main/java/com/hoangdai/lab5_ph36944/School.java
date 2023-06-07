package com.hoangdai.lab5_ph36944;

import android.widget.Spinner;

public class School {
    private int image;
    private String name;

    public School(int image, String name){
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
