/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.controller;

import getServices.dao.OfferDao;
import getServices.dao.ProviderDao;
import getServices.dao.RequestDao;
import getServices.dao.UserDao;
import getServices.model.Offers;
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
    private final RequestDao requestdao;
    private final UserDao userdao;
    private final OfferDao offerdao;
    private final ProviderDao providerdao;
    private int passedParameter;
    
    public RequestDetailsController() throws Exception {
        //logIt("moduleController constructor");
        int userid;
        requestdao = new RequestDao();
        offerdao = new OfferDao();
        providerdao = new ProviderDao();
        this.passedParameter = getPassedParameter();
        request = requestdao.getOneRequest(passedParameter);
        userid = request.getUserid();
        userdao = new UserDao();
        user = userdao.getOneUser(userid);
        offerList = offerdao.getOffersToRequest(request.getId());
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
}
