/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getServices.controller;

import getServices.dao.RequestDao;
import getServices.model.Requests;
import getServices.util.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Ibrahim Seckin
 */
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
        //logIt("moduleController constructor");
        fieldList = new ArrayList<String>();


        requestdao = new RequestDao();
        fieldList = requestdao.getList();

    }
    
    
    public void buttonRequest() throws Exception {
        requestdao = new RequestDao();
        requestdao.insertRequest(request.getUserid(), request.getField(), request.getTimelimit(),
                request.getCity(), request.getBudget(), request.getSummary());
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

    private SelectItem[] createFilterOptions(String[] data) {
        SelectItem[] options = new SelectItem[data.length + 1];

        options[0] = new SelectItem("", "Select");
        for (int i = 0; i < data.length; i++) {
            options[i + 1] = new SelectItem(data[i], data[i]);
        }

        return options;
    }

    /**
     * @return the fieldList
     */
    public List<String> getFieldList() {
        return fieldList;
    }

    /**
     * @param fieldList the fieldList to set
     */
    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    /**
     * @return the filteredFieldList
     */
    public List<String> getFilteredFieldList() {
        return filteredFieldList;
    }

    /**
     * @param filteredFieldList the filteredFieldList to set
     */
    public void setFilteredFieldList(List<String> filteredFieldList) {
        this.filteredFieldList = filteredFieldList;
    }
}
