/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.model;

/**
 *
 * @author Ibrahim Seckin
 */
public class Session {
    
    private int userId;
    private boolean isLoggedIn = false;
    private boolean isUser = true;

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the isLoggedIn
     */
    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    /**
     * @param isLoggedIn the isLoggedIn to set
     */
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    /**
     * @return the isUser
     */
    public boolean isIsUser() {
        return isUser;
    }

    /**
     * @param isUser the isUser to set
     */
    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }
}
