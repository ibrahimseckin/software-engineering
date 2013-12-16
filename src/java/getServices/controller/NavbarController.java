package getServices.controller;

import getServices.model.Session;
import static getServices.util.Logger.logIt;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "navbar")
@ViewScoped

public class NavbarController {
    private boolean isUser;
    private int userid;
    private boolean loggedIn;
    private int active;
    public NavbarController() {
        userid=0;
        loggedIn=false;
        isUser =false;
        active = 0;
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
    
    public void setActive(int ix){
        active = ix;
    }

    public int getActive() {
        return active;
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
 
    public String isActive(int ix){
        if(this.active == ix) return "active";
        else return "";
    }
}
