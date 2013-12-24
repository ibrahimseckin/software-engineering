package getServices.controller;

import getServices.dao.OfferDao;
import getServices.dao.ProviderDao;
import getServices.dao.RequestDao;
import getServices.dao.UserDao;
import getServices.model.Offers;
import getServices.model.Provider;
import getServices.model.Requests;
import getServices.model.User;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "detailsBean")
@ViewScoped
public class RequestDetailsController {
    private Requests request = new Requests();
    private User user = new User();
    private List<Offers> offerList;
    private List<Provider> providerList;
    private final RequestDao requestdao;
    private final UserDao userdao;
    private final OfferDao offerdao;
    private final ProviderDao providerdao;
    private int passedParameter;
    private Offers newOffer;
    
    public RequestDetailsController() throws Exception {
        int userid;
        requestdao = new RequestDao();
        offerdao = new OfferDao();
        userdao = new UserDao();
        providerdao = new ProviderDao();
        newOffer = new Offers();
        this.passedParameter = getPassedParameter();
        request = requestdao.getOneRequest(passedParameter);
        userid = request.getUserid();
        user = userdao.getOneUser(userid);
        offerList = offerdao.getOffersToRequest(request.getId());
    }
    
    public String selectOffer(int offerid, int requestid){
        offerdao.acceptOffer(offerid,requestid);
        return "requestDetails?faces-redirect=true&id="+passedParameter;
    }
    
    public String makeOffer(int providerid){
        newOffer.setRequestId(passedParameter);
        newOffer.setproviderId(providerid);
        offerdao.insertOffer(passedParameter, providerid, newOffer.getPrice(), newOffer.getExp());
        return "requestDetails?faces-redirect=true&id="+passedParameter;
    }
    
    public String isSuccess(boolean selected){
        if(selected) return "background: lime";
        return "";  
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

    public Requests getRequest() {
        return request;
    }

    public void setRequest(Requests request) {
        this.request = request;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public List<Offers> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offers> offerList) {
        this.offerList = offerList;
    }

    public Offers getNewOffer() {
        return newOffer;
    }

    public void setNewOffer(Offers newOffer) {
        this.newOffer = newOffer;
    }
}
