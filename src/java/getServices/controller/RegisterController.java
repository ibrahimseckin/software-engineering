/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.controller;

import getServices.dao.UserDao;
import getServices.model.User;
import getServices.util.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ibrahim Seckin <your.name at your.org>
 */

@ManagedBean(name = "register")
@ViewScoped
public class RegisterController {
    
    private User user = new User();
    UserDao userdao;
    
    private void logIt(String s) {
        Logger.logIt(s);
    }
    
    public void buttonRegister() throws Exception{
        logIt("Button Register");
        logIt("firstname:" + user.getFirstname());
        logIt("surname:" + user.getSurname());
        logIt("phone:" + user.getPhoneNumber());
        logIt("email:" + user.getEmail());
        logIt("address:" + user.getAddress());
        logIt("age:" + user.getAge());
        logIt("city:" + user.getCity());
        logIt("username:" + user.getUsername());
        logIt("password:" + user.getPassword());
        
        userdao = new UserDao();
        userdao.insertUser(user.getFirstname(), user.getSurname(), user.getPhoneNumber(), user.getEmail(), 
                user.getAddress(), user.getAge(), user.getCity(), user.getUsername(), user.getPassword());
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
    
}
