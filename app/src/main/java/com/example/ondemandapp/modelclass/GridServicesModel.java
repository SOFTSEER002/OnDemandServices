package com.example.ondemandapp.modelclass;

public class GridServicesModel {
    String servicename;
    int serviceimage;

    public GridServicesModel(String servicename, int serviceimage) {
        this.setServicename(servicename);
        this.setServiceimage(serviceimage);
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public int getServiceimage() {
        return serviceimage;
    }

    public void setServiceimage(int serviceimage) {
        this.serviceimage = serviceimage;
    }
}
