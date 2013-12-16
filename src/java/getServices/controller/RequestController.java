package getServices.controller;

import getServices.dao.RequestDao;
import getServices.model.Requests;
import getServices.util.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean(name = "requestBean")
@ViewScoped

public class RequestController {

    private Requests request = new Requests();
    RequestDao requestdao;

    private List<String> fieldList;
    private List<String> filteredFieldList;

    private void logIt(String s) {
        Logger.logIt(s);
    }
    
    public RequestController() throws Exception {
        fieldList = new ArrayList<String>();
        requestdao = new RequestDao();
        fieldList = requestdao.getListField();
        }
    
    public void buttonRequest() throws Exception {
        requestdao = new RequestDao();
        requestdao.insertRequest(request.getUserid(), request.getField(), request.getTimelimit(),
                request.getCity(), request.getBudget(), request.getSummary());
    }

    public Requests getRequest() {
        return request;
    }

    public void setRequest(Requests request) {
        this.request = request;
    }

    private SelectItem[] createFilterOptions(String[] data) {
        SelectItem[] options = new SelectItem[data.length + 1];

        options[0] = new SelectItem("", "Select");
        for (int i = 0; i < data.length; i++) {
            options[i + 1] = new SelectItem(data[i], data[i]);
        }

        return options;
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    public List<String> getFilteredFieldList() {
        return filteredFieldList;
    }

    public void setFilteredFieldList(List<String> filteredFieldList) {
        this.filteredFieldList = filteredFieldList;
    }
    
    public void authorize(boolean loggedIn, boolean isUser){
    if(!loggedIn || !isUser) try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
    } catch (IOException ex) {
        java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
