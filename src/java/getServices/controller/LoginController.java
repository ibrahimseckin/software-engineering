/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getServices.controller;

import getServices.dao.ProviderDao;
import getServices.dao.UserDao;
import getServices.model.Provider;
import getServices.model.Session;
import getServices.model.User;
import getServices.util.Logger;
import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ibrahim Seckin
 */
@ManagedBean(name = "login")
@SessionScoped

public class LoginController implements Serializable {

    UserDao userdao;
    ProviderDao providerdao;
    private User user = new User();
    private Provider provider = new Provider();
    private Session session = new Session();

    private void logIt(String s) {
        Logger.logIt(s);
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    public String login() throws Exception {
        logIt("login calisti");
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;

        userdao = new UserDao();
        int userId = userdao.getUserId(user.getUsername(), user.getPassword());
        if (userId != 0) {
            loggedIn = true;
        }

        if (loggedIn == true) {
            logIt("basariliya girdi");
            session.setUserId(userId);
            session.setIsLoggedIn(true);
            session.setIsUser(true);

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("key", user);
            Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessionMap.put("session", session);
            return "userpage?faces-redirect=true";

        } else {
            logIt("else'e girdi");
            int providerId = 0;
            providerdao = new ProviderDao();
            providerId = providerdao.getProviderId(user.getUsername(), user.getPassword());
            logIt("cikti");
            if (providerId != 0) {
                loggedIn = true;

            }
            if (loggedIn == true) {
                logIt("basariliya girdi");
                session.setUserId(providerId);
                session.setIsLoggedIn(true);
                session.setIsUser(false);

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("key", user);
                Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
                sessionMap.put("session", session);
                return "userpage?faces-redirect=true";
            } else {
                logIt("basarisiza girdi");
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setSummary("Unknown login!");
                message.setDetail("ERROR MESSAGE");
                FacesContext.getCurrentInstance().addMessage("formId:form",message);
            //FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unknown login.Try again",null);
                //return "index?faces-redirect=true";
                return "error";
            }
        }

    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
