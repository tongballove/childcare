/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.childcare.entities;

/**
 *
 * @author Dang Van Thanh
 */
public class Nanny {

    private String nannyid;
    private Integer classid;
    private String name;
    private String address;
    private Integer contactnumber;
    private double charge;
    private int workinghour;

    public Nanny() {
    }

    public Nanny(String nannyid) {
        this.nannyid = nannyid;
    }

    public Nanny(String nannyid, String name, String address, double charge, int workinghour) {
        this.nannyid = nannyid;
        this.name = name;
        this.address = address;
        this.charge = charge;
        this.workinghour = workinghour;
    }

    public String getNannyid() {
        return nannyid;
    }

    public void setNannyid(String nannyid) {
        this.nannyid = nannyid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(Integer contactnumber) {
        this.contactnumber = contactnumber;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public int getWorkinghour() {
        return workinghour;
    }

    public void setWorkinghour(int workinghour) {
        this.workinghour = workinghour;
    }
}
