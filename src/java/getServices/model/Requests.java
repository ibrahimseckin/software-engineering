/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.model;

import java.util.Date;

/**
 *
 * @author Ibrahim Seckin
 */
public class Requests {
    private int id;
    private int userid;
    private String field;
    private Date timelimit;
    private Date requestDate;
    private String city;
    private double budget;
    private String summary;
    
    public Requests(){} //default constructor
    
    public Requests(String field,Date timelimit,Date requestDate, String city,double budget, String summary){
        this.field = field;
        this.timelimit = timelimit;
        this.requestDate = requestDate;
        this.city = city;
        this.budget = budget;
        this.summary = summary;
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * @return the timelimit
     */
    public Date getTimelimit() {
        return timelimit;
    }

    /**
     * @param timelimit the timelimit to set
     */
    public void setTimelimit(Date timelimit) {
        this.timelimit = timelimit;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the budget
     */
    public double getBudget() {
        return budget;
    }

    /**
     * @param budget the budget to set
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the requestDate
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

}
