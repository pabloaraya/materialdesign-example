package com.pabloaraya.materialdesign;

/**
 * Created by pablo on 2/21/15.
 */
public class ItemModel {
    private int image;
    private String text;

    public ItemModel(int image, String text){
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
