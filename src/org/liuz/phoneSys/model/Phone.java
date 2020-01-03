package org.liuz.phoneSys.model;

import java.io.Serializable;

/**
 * Phone class
 */
public class Phone implements Serializable {
    /**编号**/
    private int id;
    /** 品牌*/
    private String brand;
    /**手机型号*/
    private String type;
    /**手机价格*/
    private int price;
    /**手机库存*/
    private int repertory;
    public Phone(){

    }

    public Phone(int id,String brand, String type, int price, int repertory) {
        this.id=id;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.repertory = repertory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRepertory() {
        return repertory;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return   id + "\t" +brand + '\t' + type + '\t'+(type.length()<3?'\t':"") +price + "￥\t" + repertory;
    }
}
