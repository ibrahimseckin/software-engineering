/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getServices.controller;

import getServices.dao.RequestDao;
import getServices.model.Requests;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Ibrahim Seckin
 */
@ManagedBean(name = "userpage")
@ViewScoped
public class UserPageController {
    
    private Requests request = new Requests();
    private boolean opened;
    
    private List<Requests> requestList;
    private List<Requests> filteredRequestList;
    RequestDao requestdao;

    public UserPageController() throws Exception {
        //logIt("moduleController constructor");
        requestList = new ArrayList<Requests>();
        

        
    }
    
    public void openRequestTab() throws Exception {
        if(!opened){
            requestdao = new RequestDao();
            requestList = requestdao.getRequest();
            }
        opened=true;
    }
    /**
     * @return the requestList
     */
    public List<Requests> getRequestList() {
        return requestList;
    }

    /**
     * @param requestList the requestList to set
     */
    public void setRequestList(List<Requests> requestList) {
        this.requestList = requestList;
    }

    /**
     * @return the filteredRequestList
     */
    public List<Requests> getFilteredRequestList() {
        return filteredRequestList;
    }

    /**
     * @param filteredRequestList the filteredRequestList to set
     */
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

    /**
     * @return the request
     */
    public Requests getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(Requests request) {
        this.request = request;
    }
}
