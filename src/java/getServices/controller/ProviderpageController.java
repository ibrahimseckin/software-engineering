package getServices.controller;

import getServices.dao.ProviderDao;
import getServices.model.Provider;
import static getServices.util.Logger.logIt;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "providerpage")
@ViewScoped
/**
 *
 * @author yiğido
 */
public class ProviderpageController {
    
    ProviderDao providerdao;
    private List<Provider> providerList;
    private List<Provider> filteredProviderList;
    
    
    public ProviderpageController() throws Exception {
        logIt("sdsdf");
        providerList = new ArrayList<Provider>();
        providerdao = new ProviderDao();
        providerList = providerdao.getProviders();
    }
    
    public List<Provider> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<Provider> providerList) {
        this.providerList = providerList;
    }

    public List<Provider> getFilteredProviderList() {
        return filteredProviderList;
    }

    public void setFilteredProviderList(List<Provider> filteredProviderList) {
        this.filteredProviderList = filteredProviderList;
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
