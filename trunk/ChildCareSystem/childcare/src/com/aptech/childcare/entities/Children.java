/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.childcare.entities;

import java.util.Date;

/**
 *
 * @author Dang Van Thanh
 */
public class Children {

    private String childid;
    private String lastname;
    private String firstname;
    private String middlename;
    private String sex;
    private Date birthday;
    private String address;
    private String medication;
    private String illness;
    private String doctorname;
    private String parentname;
    private String parenworknumber;
    private Integer parentphone;
    private String parentemail;
    private String contact;
    private Classes classes;

    public Children() {
    }

    public Children(String childid) {
        this.childid = childid;
    }

    public Children(String childid, String lastname, String firstname, String sex, Date birthday, String address, String parentname, String parenworknumber) {
        this.childid = childid;
        this.lastname = lastname;
        this.firstname = firstname;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.parentname = parentname;
        this.parenworknumber = parenworknumber;
    }

    public String getChildid() {
        return childid;
    }

    public void setChildid(String childid) {
        this.childid = childid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getParenworknumber() {
        return parenworknumber;
    }

    public void setParenworknumber(String parenworknumber) {
        this.parenworknumber = parenworknumber;
    }

    public Integer getParentphone() {
        return parentphone;
    }

    public void setParentphone(Integer parentphone) {
        this.parentphone = parentphone;
    }

    public String getParentemail() {
        return parentemail;
    }

    public void setParentemail(String parentemail) {
        this.parentemail = parentemail;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the classes
     */
    public Classes getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
