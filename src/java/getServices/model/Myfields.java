/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.model;

/**
 *
 * @author yiğido
 */
public class Myfields {
    private int id;
    private int fieldId;
    private int providerId;

    
    public Myfields(int id, int fieldId,int providerId ){
        this.id=id;
        this.fieldId=fieldId;
        this.providerId=providerId;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fieldId
     */
    public int getFieldId() {
        return fieldId;
    }

    /**
     * @param fieldId the fieldId to set
     */
    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    /**
     * @return the providerId
     */
    public int getProviderId() {
        return providerId;
    }

    /**
     * @param providerId the providerId to set
     */
    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
    
    
}
