package getServices.controller;

import getServices.dao.ServicesDao;
import getServices.dao.UserDao;
import getServices.model.Provider;
import getServices.model.User;
import getServices.util.Logger;
import java.io.IOException;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
    }

    public void providerRegister() throws Exception {
        servicesdao = new ServicesDao();
        servicesdao.insertProvider(provider.getPname(), provider.getPhoneNumber(), provider.getEmail(), provider.getAddress(),
                provider.getCity(), provider.getField(), provider.getUsername(), provider.getPassword());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
    public void authorize(boolean loggedIn){
    if(loggedIn) try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
    } catch (IOException ex) {
        java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
