/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getServices.controller;

import getServices.dao.ServicesDao;
import getServices.dao.UserDao;
import getServices.model.Provider;
import getServices.model.Session;
import getServices.model.User;
import getServices.util.Logger;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ibrahim Seckin <your.name at your.org>
 */
@ManagedBean(name = "register")
@ViewScoped
public class RegisterController {

    private User user = new User();
    private Provider provider = new Provider();

    UserDao userdao;
    ServicesDao servicesdao;

    private void logIt(String s) {
        Logger.logIt(s);
    }

    public void buttonRegister() throws Exception {
        userdao = new UserDao();
        userdao.insertUser(user.getFirstname(), user.getSurname(), user.getPhoneNumber(), user.getEmail(),
                user.getAddress(), user.getAge(), user.getCity(), user.getUsername(), user.getPassword());
        Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        Session session =  (Session)sessionMap.get("session");
        logIt("userid" + session.getUserId());
        
    }

    public void providerRegister() throws Exception {

        servicesdao = new ServicesDao();
        servicesdao.insertProvider(provider.getPname(), provider.getPhoneNumber(), provider.getEmail(), provider.getAddress(),
                provider.getCity(), provider.getField(), provider.getUsername(), provider.getPassword());
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the provider
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * @param provider the provider to set
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

}
