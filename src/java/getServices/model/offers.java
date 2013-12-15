/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.model;

/**
 *
 * @author samil.can
 */
public class offers {
    private int id;
    private int requestId;
    private int providerId;
    private int price;
    private String exp;
    
    public offers(){}
    
    public offers(int id, int requestId, int providerId, int price, String exp){
        
        this.id =  id;
        this.requestId =  requestId;
        this.providerId =  providerId;
        this.price =  price;
        this.exp = exp;
    
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;    
    }
    
    public int getRequestId(){
        return requestId;
    }
    
    public void setRequestId(int requestId){
        this.requestId = requestId;    
    }
    public int getProviderId(){
        return providerId;
    }
    
    public void setproviderId(int providerId){
        this.providerId = providerId;    
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int id){
        this.price = price;    
    }
    
    public String getExp(){
        return exp;
    }
    
    public void setExp(String exp){
        this.exp = exp;    
    }
    
    
}
