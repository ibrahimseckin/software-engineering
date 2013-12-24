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
    
    private int providerid;
    private String firstname;
    private String surname;
    private String username;
    private String content;
    
    public Comments(){}
    
    Comments(int providerId, String firstName, String surName, String userName, String conTent){
        this.providerid = providerId;
        this.firstname = firstName;
        this.surname = surName;
        this.username = userName;
        this.content = conTent;    
    }
    /**
     * @return the providerid
     */
    public int getProviderid() {
        return providerid;
    }

    /**
     * @param providerid the providerid to set
     */
    public void setProviderid(int providerid) {
        this.providerid = providerid;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
}
