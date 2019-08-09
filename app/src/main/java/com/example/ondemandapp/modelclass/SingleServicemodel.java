package com.example.ondemandapp.modelclass;

public class SingleServicemodel {
    int image,count;
    String serviceid,servicename,serviceoffprice,serviceoriginalprice,servicediscount,servicetype,servicetime;

    public SingleServicemodel(int image, String serviceid, String servicename, String serviceoffprice,
                              String serviceoriginalprice, String servicediscount, String servicetype, String servicetime,int count) {
       this.setServiceid(serviceid);
       this.setServicename(servicename);
       this.setServiceoffprice(serviceoffprice);
       this.setServiceoriginalprice(serviceoriginalprice);
       this.setServicediscount(servicediscount);
       this.setServicetype(servicetype);
       this.setServicetime(servicetime);
       this.setImage(image);
       this.setCount(count);
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getServiceoffprice() {
        return serviceoffprice;
    }

    public void setServiceoffprice(String serviceoffprice) {
        this.serviceoffprice = serviceoffprice;
    }

    public String getServiceoriginalprice() {
        return serviceoriginalprice;
    }

    public void setServiceoriginalprice(String serviceoriginalprice) {
        this.serviceoriginalprice = serviceoriginalprice;
    }

    public String getServicediscount() {
        return servicediscount;
    }

    public void setServicediscount(String servicediscount) {
        this.servicediscount = servicediscount;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public String getServicetime() {
        return servicetime;
    }

    public void setServicetime(String servicetime) {
        this.servicetime = servicetime;
    }
}
