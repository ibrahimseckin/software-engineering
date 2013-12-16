package getServices.controller;

import getServices.dao.ProviderDao;
import getServices.dao.RequestDao;
import getServices.dao.UserDao;
import getServices.model.Provider;
import getServices.model.Requests;
import getServices.model.Session;
import getServices.model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean(name = "userpage")
@ViewScoped
public class UserPageController {

    private Requests request = new Requests();
    private boolean opened;
    private User user;
    private Provider provider;
    private List<Requests> requestList;
    private List<Requests> filteredRequestList;
    RequestDao requestdao;
    UserDao userdao;
    ProviderDao providerdao;

    public UserPageController() throws Exception {
        requestList = new ArrayList<Requests>();
        userdao = new UserDao();
        provider = new Provider();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        Session session = (Session) sessionMap.get("session");
        if (session != null) {
            if(session.isIsUser()){
            user = userdao.getOneUser(session.getUserId());
            }
            else{
            provider = providerdao.getOneProvider(session.getUserId());
            }
        }
    }

    public void openRequestTab() throws Exception {
        if (!opened) {
            requestdao = new RequestDao();
            Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            Session session = (Session) sessionMap.get("session");
            int userId = session.getUserId();
            requestList = requestdao.getRequest(userId);
        }
        opened = true;
    }

    public List<Requests> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Requests> requestList) {
        this.requestList = requestList;
    }

    public List<Requests> getFilteredRequestList() {
        return filteredRequestList;
    }

    public void setFilteredRequestList(List<Requests> filteredRequestList) {
        this.filteredRequestList = filteredRequestList;
    }

    private SelectItem[] createFilterOptions(String[] data) {
        SelectItem[] options = new SelectItem[data.length + 1];

        options[0] = new SelectItem("", "Select");
        for (int i = 0; i < data.length; i++) {
            options[i + 1] = new SelectItem(data[i], data[i]);
        }
        return options;
    }

    public Requests getRequest() {
        return request;
    }

    public void setRequest(Requests request) {
        this.request = request;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void authorize(boolean loggedIn) {
        if (!loggedIn) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
