/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.childcare.entities;

/**
 *
 * @author Dang Van Thanh
 */
public class Classes {

    private Integer classid;
    private String classname;
    private String notes;
    private AgeGroup ageGroup;

    public Classes() {
    }

    public Classes(Integer classid) {
        this.classid = classid;
    }

    public Classes(Integer classid, String classname) {
        this.classid = classid;
        this.classname = classname;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }
}
