/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.dao;

import getServices.model.Provider;
import getServices.util.Logger;
import static getServices.util.Logger.logIt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samil.can
 */
public class ProviderDao extends DaoConnect {
    
    PreparedStatement pstatement = null;
    Statement statement;
    ResultSet result;
    
    private List<String> fieldList;
    private List<Provider> providerList;
    
    public ProviderDao() throws Exception {
        connect();
    }
    
    public void insertProvider(String pname, String phoneNumber, String email, String address,
            String city, String username, String password) {
        try {
            
            String query = "Insert into providers" + "(pname,phoneno,email,address,city,rate,username,password,resume)"
                    + "values (?,?,?,?,?,?,?,?,?) ";

            pstatement = conn.prepareStatement(query);
            //pstatement.setInt(1, 1);
            pstatement.setString(1,pname );
            pstatement.setString(2, phoneNumber);
            pstatement.setString(3, email);
            pstatement.setString(4, address);
            pstatement.setString(5, city);
            pstatement.setString(6, username);
            pstatement.setString(7, password);
            pstatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

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
    
    public List<Provider> getProviders() {
        try {
            setProviderList(new ArrayList<Provider>());
            String query = "SELECT * from (providers) ";

            statement = conn.createStatement();
            result = statement.executeQuery(query);
logIt("sdfzxc");
            while (result.next()) {
                logIt("sdf");
                int id = result.getInt("id");
                String pname = result.getString("pname");
                String phoneno = result.getString("phoneno");
                String email = result.getString("email");
                String address = result.getString("address");
                String city = result.getString("city");
                //Double rate = result.getDouble("rate");

                getProviderList().add(new Provider(id,pname,phoneno,email,address,city));
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return getProviderList();
    }
    
    public void setProviderList(List<Provider> providerList) {
        this.providerList = providerList;
    }
    
        public List<Provider> getProviderList() {
        return providerList;
    }
    
    
    
}
