package getServices.controller;

import getServices.dao.FieldDao;
import getServices.dao.ProviderDao;
import getServices.dao.RequestDao;
import getServices.dao.UserDao;
import getServices.model.Fields;
import getServices.model.Provider;
import getServices.model.Session;
import getServices.model.User;
import getServices.util.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "register")
@SessionScoped
public class RegisterController {

    private User user = new User();
    private Provider provider = new Provider();
    private List<String> sfieldList;
    private List<Fields> fieldList;

    Map<String, Object> sessionMap;
    Session session;

    RequestDao requestdao;
    FieldDao fielddao;

    private void logIt(String s) {
        Logger.logIt(s);
    }

    public RegisterController() throws Exception {
        logIt("register controller girdi");
        sfieldList = new ArrayList<String>();
        logIt("request dao cagirildi");
        requestdao = new RequestDao();
        logIt("request dao bitti");
        sfieldList = requestdao.getListField();
        logIt("field dao cagirildi");
        fielddao = new FieldDao();
        logIt("field dao bitti");
        logIt("size:" + sfieldList.size());
        fieldList = new ArrayList<Fields>();
        for (int i = 0; i < sfieldList.size(); i++) {
            fieldList.add(fielddao.getFieldObject(sfieldList.get(i)));
            logIt("field:" + sfieldList.get(i));
        }
        logIt("for calisti");
    }

    UserDao userdao;
    ProviderDao providerdao;

    public String buttonRegister() throws Exception {
        FacesMessage message = new FacesMessage();
        userdao = new UserDao();
        providerdao = new ProviderDao();
        if (providerdao.isRegisteredAlready(user.getUsername())) {
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            message.setSummary("Username already Exists");
            message.setDetail("Please use another username");
            FacesContext.getCurrentInstance().addMessage("formId:register", message);
            return null;
        }

        userdao.insertUser(user.getFirstname(), user.getSurname(), user.getPhoneNumber(), user.getEmail(),
                user.getAddress(), user.getAge(), user.getCity(), user.getUsername(), user.getPassword());

        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Succesfull Register");
        message.setDetail("Succesfull Register");
        FacesContext.getCurrentInstance().addMessage("formId:register", message);
        return "login?faces-redirect=true";
    }

    public String providerRegister() throws Exception {
        logIt("provider register butonu calisti");
        FacesMessage message = new FacesMessage();
        providerdao = new ProviderDao();
        if (providerdao.isRegisteredAlready(provider.getUsername())) {
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            message.setSummary("Username already Exists");
            message.setDetail("Please use another username");
            FacesContext.getCurrentInstance().addMessage("formId:register", message);
            return null;
        }
        providerdao.insertProvider(provider.getPname(), provider.getPhoneNumber(), provider.getEmail(), provider.getAddress(),
                provider.getCity(), provider.getUsername(), provider.getPassword());
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        session = (Session) sessionMap.get("session");
        logIt("last id:" +providerdao.getLastId());
        logIt("field ekleme basladi");
        for(int i=0; i<fieldList.size(); i++){  
        fielddao.insertMyField(fieldList.get(i).getId(),providerdao.getLastId());
        }
        logIt("field ekleme bitti");
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Succesfull Register");
        message.setDetail("Succesfull Register");
        FacesContext.getCurrentInstance().addMessage("formId:register", message);
        return "login?faces-redirect=true";
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

    public void authorize(boolean loggedIn) {
        if (loggedIn) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Fields> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Fields> fieldList) {
        this.fieldList = fieldList;
    }

    /**
     * @return the sfieldList
     */
    public List<String> getSfieldList() {
        return sfieldList;
    }

    /**
     * @param sfieldList the sfieldList to set
     */
    public void setSfieldList(List<String> sfieldList) {
        this.sfieldList = sfieldList;
    }

}
