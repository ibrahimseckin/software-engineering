/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.controller;

import getServices.dao.UserDao;
import getServices.model.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ibrahim Seckin
 */

@ManagedBean(name = "login")
@ViewScoped

public class LoginController {
    
    UserDao userdao;
    private User user = new User();

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }
    
    public void buttonLogin() throws Exception{
        boolean isRegistered = false;
        userdao = new UserDao();
        isRegistered = userdao.isRegistered(user.getUsername(), user.getPassword());
        System.out.println("isRegistered:" + isRegistered);
    }
    
    
    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
