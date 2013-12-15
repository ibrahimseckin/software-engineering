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
public class Comments {
    
    private int id;
    private int userId;
    private int providerId;
    private String content;
    
    Comments(){}
    
    Comments(int id, int userId, int providerId, String content){
        this.id = id;
        this.providerId = providerId;
        this.userId = userId;
        this.content = content;    
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;    
    }
    
    public int getProviderId(){
        return providerId;
    }
    
    public void setProviderId(int providerId){
        this.providerId = providerId;    
    }
    
    public int getUserId(){
        return userId;
    }
    
    public void setUserId(int userId){
        this.userId = userId;    
    }
    
    public String getContent(){
        return content;
    }
    
    public void setContent(String content){
        this.content = content;    
    }
    
}
