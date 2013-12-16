package getServices.controller;

import getServices.dao.ProviderDao;
import getServices.model.Provider;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "detailsProvider")
@ViewScoped

/**
 *
 * @author yiğido
 */
public class ProviderDetailsController {
    
    private Provider provider = new Provider();
//    private List<Field> fieldList;
    private final ProviderDao providerdao;
    private int passedParameter;
    
    public ProviderDetailsController() throws Exception{
        providerdao = new ProviderDao();
        this.passedParameter = getPassedParameter();
        provider = providerdao.getOneProvider(getPassedParameter());
    }
    
    
    public final int getPassedParameter() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.passedParameter = Integer.parseInt(facesContext.getExternalContext().
                getRequestParameterMap().get("id"));
        return this.passedParameter;
    }
    
    public void setPassedParameter(int passedParameter) {
        this.passedParameter = passedParameter;
    }
    
    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
}
