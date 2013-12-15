/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.controller;

import getServices.dao.RequestDao;
import getServices.model.Requests;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "detailsBean")
@ViewScoped
public class RequestDetailsController {
    private Requests request = new Requests();
    RequestDao requestdao;
    private int passedParameter;
    
    public RequestDetailsController() throws Exception {
        //logIt("moduleController constructor");
        requestdao = new RequestDao();
        this.passedParameter = getPassedParameter();
        request = requestdao.getOneRequest(getPassedParameter());

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
}
