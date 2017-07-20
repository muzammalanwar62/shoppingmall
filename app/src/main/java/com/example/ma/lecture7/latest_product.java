package com.example.ma.lecture7;

/**
 * Created by MA on 7/12/2017.
 */

public class latest_product {
    int image;

    public latest_product(int image, int discountprice, String prdctname, String prdctprice) {
        this.image = image;
        this.discountprice = discountprice;
        this.prdctname = prdctname;
        this.prdctprice = prdctprice;
    }

    public int getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(int discountprice) {
        this.discountprice = discountprice;
    }

    int discountprice;
    String prdctname,prdctprice;


    public latest_product(int image, String prdctname, String prdctprice) {
        this.image = image;
        this.prdctname = prdctname;
        this.prdctprice = prdctprice;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrdctname() {
        return prdctname;
    }

    public void setPrdctname(String prdctname) {
        this.prdctname = prdctname;
    }

    public String getPrdctprice() {
        return prdctprice;
    }

    public void setPrdctprice(String prdctprice) {
        this.prdctprice = prdctprice;
    }
}
