/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.childcare.entities;

/**
 *
 * @author Dang Van Thanh
 */
public class AgeGroup {

    private Integer agegroupid;
    private String agegroup;
    private double fees;
    private String notes;

    public AgeGroup() {
    }

    public AgeGroup(Integer agegroupid) {
        this.agegroupid = agegroupid;
    }

    public AgeGroup(Integer agegroupid, String agegroup, double fees) {
        this.agegroupid = agegroupid;
        this.agegroup = agegroup;
        this.fees = fees;
    }

    public Integer getAgegroupid() {
        return agegroupid;
    }

    public void setAgegroupid(Integer agegroupid) {
        this.agegroupid = agegroupid;
    }

    public String getAgegroup() {
        return agegroup;
    }

    public void setAgegroup(String agegroup) {
        this.agegroup = agegroup;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
