/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.childcare.entities;

/**
 *
 * @author Dang Van Thanh
 */
public class Activity {

    private Integer activityid;
    private String activityname;
    private String description;

    public Activity() {
    }

    public Activity(Integer activityid) {
        this.activityid = activityid;
    }

    public Activity(Integer activityid, String activityname) {
        this.activityid = activityid;
        this.activityname = activityname;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
