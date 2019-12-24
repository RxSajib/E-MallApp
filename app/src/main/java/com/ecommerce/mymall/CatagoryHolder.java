package com.ecommerce.mymall;

public class CatagoryHolder {

    String catagoryimage;
    String catagoryname;

    public CatagoryHolder(String catagoryimage, String catagoryname) {
        this.catagoryimage = catagoryimage;
        this.catagoryname = catagoryname;
    }

    public String getCatagoryimage() {
        return catagoryimage;
    }

    public void setCatagoryimage(String catagoryimage) {
        this.catagoryimage = catagoryimage;
    }

    public String getCatagoryname() {
        return catagoryname;
    }

    public void setCatagoryname(String catagoryname) {
        this.catagoryname = catagoryname;
    }
}
