/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getServices.dao;

import static getServices.dao.DaoConnect.conn;
import getServices.model.Fields;
import getServices.model.Provider;
import getServices.util.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ibrahim Seckin
 */
public class FieldDao extends DaoConnect {

    PreparedStatement pstatement = null;
    Statement statement;
    ResultSet result;

    private List<Fields> fList;
    private List<String> stringFList;
    private List<Integer> fieldIdList;

    private void logIt(String s) {
        Logger.logIt(s);
    }

    public FieldDao() throws Exception {
        connect();
    }

    public List<Fields> getListField() {
        logIt("getListField calisti");
        try {
            setfList(new ArrayList<Fields>());
            String query = "SELECT id,name FROM (fields) ";

            statement = conn.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String field = result.getString("name");
                logIt("field:" + field);
                getfList().add(new Fields(id, field));
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        logIt("getFieldList cikti");
        return getfList();
    }
    
    public Fields getFieldObject(String fieldName){
        logIt("getFieldObject calisti");
        Fields field = new Fields();
        int id = 0;
        String name;
        try {
            logIt("sorgu yapiyor");
            String query = "SELECT  id,name from (fields) WHERE name = ?";
            pstatement = conn.prepareStatement(query);
            pstatement.setString(1, fieldName);
            result = pstatement.executeQuery();

            logIt("sorgudan cikti");
            if (result.next()) {
                id = result.getInt("id");
                logIt("id:" + id);
                name = result.getString("name");
                logIt("name:"+name);
                field = new Fields(id,name);
            }
            return field;

        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
    }
    
    public void insertMyField(int fieldId, int providerId){
         try {
            
            String query = "Insert into myfields" + "(fieldid,providerid)"
                    + "values (?,?) ";

            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, fieldId);
            pstatement.setInt(2, providerId);
            pstatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }
    public boolean isRegisteredAlready(String username){
        try {
            
            String query = "Select username from providers where username = ?";
            pstatement = conn.prepareStatement(query);
            pstatement.setString(1, username);
            result = pstatement.executeQuery();
            if(result.first()) return true;
            
            query = "Select username from users where username = ?";
            pstatement = conn.prepareStatement(query);
            pstatement.setString(1, username);
            result = pstatement.executeQuery();
            if(result.first()) return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    
    public void insertProviderFields(){}
    
    public int getProviderId(String username, String password) {
        int providerId = 0;
        try {
            String query = "SELECT  id from (providers) WHERE username =? AND password =? ";
            pstatement = conn.prepareStatement(query);
            pstatement.setString(1, username);
            pstatement.setString(2, password);
            result = pstatement.executeQuery();

            if (result.next()) {
                providerId = result.getInt(1);
            }
            return providerId;

        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
    }
    
    public List<String> getStringListField() {
        logIt("getListField calisti");
        try {
            setStringFList(new ArrayList<String>());
            String query = "SELECT name FROM (fields) ";

            statement = conn.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                String field = result.getString("name");
                logIt("field:" + field);
                getStringFList().add(field);
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        logIt("getFieldList cikti");
        return getStringFList();
    }

    /*
    public List<Integer> getFieldId(Provider provider) {
        try {
            setFieldIdList(new ArrayList<Integer>());
            String query = "SELECT id FROM (fields) where name = ? ";

            pstatement = conn.prepareStatement(query);
            pstatement.setString(1, pro);
            pstatement.setString(2, password);
            result = pstatement.executeQuery();

            while (result.next()) {
                String field = result.getString("name");
                logIt("field:" + field);
                getStringFList().add(field);
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        logIt("getFieldList cikti");
        return getStringFList();
    }
    */
    
    /**
     * @return the fList
     */
    public List<Fields> getfList() {
        return fList;
    }

    /**
     * @param fList the fList to set
     */
    public void setfList(List<Fields> fList) {
        this.fList = fList;
    }

    /**
     * @return the stringFList
     */
    public List<String> getStringFList() {
        return stringFList;
    }

    /**
     * @param stringFList the stringFList to set
     */
    public void setStringFList(List<String> stringFList) {
        this.stringFList = stringFList;
    }

    /**
     * @return the fieldIdList
     */
    public List<Integer> getFieldIdList() {
        return fieldIdList;
    }

    /**
     * @param fieldIdList the fieldIdList to set
     */
    public void setFieldIdList(List<Integer> fieldIdList) {
        this.fieldIdList = fieldIdList;
    }

}
