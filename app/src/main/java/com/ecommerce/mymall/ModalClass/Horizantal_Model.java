package com.ecommerce.mymall.ModalClass;

public class Horizantal_Model {

    private int Horizantalimeg;
    private String Horitalproductname;
    private String Horizantalproductdetails;
    private String HorizantalproductPrice;


    public Horizantal_Model(int horizantalimeg, String horitalproductname, String horizantalproductdetails, String horizantalproductPrice) {
        Horizantalimeg = horizantalimeg;
        Horitalproductname = horitalproductname;
        Horizantalproductdetails = horizantalproductdetails;
        HorizantalproductPrice = horizantalproductPrice;
    }

    public int getHorizantalimeg() {
        return Horizantalimeg;
    }

    public void setHorizantalimeg(int horizantalimeg) {
        Horizantalimeg = horizantalimeg;
    }

    public String getHoritalproductname() {
        return Horitalproductname;
    }

    public void setHoritalproductname(String horitalproductname) {
        Horitalproductname = horitalproductname;
    }

    public String getHorizantalproductdetails() {
        return Horizantalproductdetails;
    }

    public void setHorizantalproductdetails(String horizantalproductdetails) {
        Horizantalproductdetails = horizantalproductdetails;
    }

    public String getHorizantalproductPrice() {
        return HorizantalproductPrice;
    }

    public void setHorizantalproductPrice(String horizantalproductPrice) {
        HorizantalproductPrice = horizantalproductPrice;
    }
}
