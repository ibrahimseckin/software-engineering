package getServices.controller;

import getServices.dao.RequestDao;
import getServices.dao.UserDao;
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
    private List<Requests> requestList;
    private List<Requests> filteredRequestList;
    RequestDao requestdao;
    UserDao userdao;

    public UserPageController() throws Exception {
        requestList = new ArrayList<Requests>();
        userdao = new UserDao();
        Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        Session session =  (Session)sessionMap.get("session");
        if(session != null){
            user = userdao.getOneUser(session.getUserId());
        }
    }
    
    public void openRequestTab() throws Exception {
        if(!opened){
            requestdao = new RequestDao();
            requestList = requestdao.getRequest();
            }
        opened=true;
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
    
    public void authorize(boolean loggedIn){
    if(!loggedIn) try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
    } catch (IOException ex) {
        java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
