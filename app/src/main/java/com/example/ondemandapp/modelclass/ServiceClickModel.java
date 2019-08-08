package com.example.ondemandapp.modelclass;

public class ServiceClickModel {
    String text,id;
    int image;


    public ServiceClickModel(String text, int image,String id) {
        this.setText(text);
        this.setImage(image);
        this.setId(id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
