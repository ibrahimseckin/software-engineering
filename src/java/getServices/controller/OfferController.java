/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.controller;

import getServices.dao.OfferDao;
import getServices.model.Offers;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author samil.can
 */

@ManagedBean(name = "offerBean")
@ViewScoped

public class OfferController {
    
    final Offers offer = new Offers();
    OfferDao offerdao;
    
    public OfferController() throws Exception{
        offerdao = new OfferDao();
    }
    
    public void buttonOffer() throws Exception {
        offerdao.insertOffer(offer.getRequestId(), offer.getProviderId(), offer.getPrice(),
                offer.getExp());
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
