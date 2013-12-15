package getServices.controller;

import getServices.dao.RequestDao;
import getServices.model.Requests;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "homepage")
@ViewScoped

public class HomepageController {

    RequestDao requestdao;

    private List<Requests> requestList;
    private List<Requests> filteredRequestList;

    public HomepageController() throws Exception {
        requestList = new ArrayList<Requests>();
        requestdao = new RequestDao();
        requestList = requestdao.getRequest();
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
}
