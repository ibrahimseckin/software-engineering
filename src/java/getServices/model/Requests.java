package getServices.model;

import java.util.Date;
import getServices.dao.RequestDao;

public class Requests {
    private int id;
    private int userid;
    private String title;
    private String field;
    private Date timelimit;
    private Date requestDate;
    private String city;
    private int budget;
    private String summary;
    private int selectedOffer;
    
    public Requests(){} //default constructor
    
    public Requests(int id1,int userid1,String title1,String field,Date timelimit,Date requestDate, String city, int budget, String summary){
        this.field = field;
        this.id = id1;
        this.userid = userid1;
        this.title = title1;
        this.timelimit = timelimit;
        this.requestDate = requestDate;
        this.city = city;
        this.budget = budget;
        this.summary = summary;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Date getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Date timelimit) {
        this.timelimit = timelimit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(int selectedOffer) {
        this.selectedOffer = selectedOffer;
    }
}
