/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.controller;

import getServices.model.Session;
import static getServices.util.Logger.logIt;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author pc
 */

@ManagedBean(name = "navbar")
@ViewScoped

public class NavbarController {
    private boolean isUser;
    private int userid;
    private boolean loggedIn;
    private String active1;
    private String active2;
    private String active3;
    private String active4;
    private String active5;
    private String active6;
    
    public NavbarController() {
        userid=0;
        loggedIn=false;
        isUser =false;
        active1="";
        active2="";
        active3="";
        active4="";
        active5="";
        active6="";
        Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        Session session =  (Session)sessionMap.get("session");
        if(session != null){
            userid = session.getUserId();
            loggedIn = session.isIsLoggedIn();
            isUser = session.isIsUser();
        }
        else{
        
        }
    }
    
    public void setActive(int i){
        active1="";
        active2="";
        active3="";
        active4="";
        active5="";
        active6="";
        if(i==1) active1="active";
        if(i==2) active2="active";
        if(i==3) active3="active";
        if(i==4) active4="active";
        if(i==5) active5="active";
        if(i==6) active6="active";
    }
    
    public void setActive1(String active1) {
        this.active1 = active1;
    }

    public String getActive1() {
        return active1;
    }

    public String getActive2() {
        return active2;
    }

    public String getActive3() {
        return active3;
    }

    public String getActive4() {
        return active4;
    }

    public String getActive5() {
        return active5;
    }

    public String getActive6() {
        return active6;
    }

    public void setActive2(String active2) {
        this.active2 = active2;
    }

    public void setActive3(String active3) {
        this.active3 = active3;
    }

    public void setActive4(String active4) {
        this.active4 = active4;
    }

    public void setActive5(String active5) {
        this.active5 = active5;
    }

    public void setActive6(String active6) {
        this.active6 = active6;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public boolean isIsUser() {
        return isUser;
    }

    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    
    
    
    
}
