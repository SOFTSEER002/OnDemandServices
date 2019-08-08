package com.example.ondemandapp.modelclass;

public class Womenmodel {
    String type,id;
    int typeimage;

    public Womenmodel(String type, int typeimage,String id) {
       this.setType(type);
       this.setTypeimage(typeimage);
       this.setId(id);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTypeimage() {
        return typeimage;
    }

    public void setTypeimage(int typeimage) {
        this.typeimage = typeimage;
    }
}
