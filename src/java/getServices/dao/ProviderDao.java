/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.dao;

import getServices.util.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author samil.can
 */
public class ProviderDao extends DaoConnect {
    
    PreparedStatement pstatement = null;
    Statement statement;
    ResultSet result;
    
    
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
    
    public boolean isRegistered(String username, String password){
        boolean isRegistered = false;
        try{
            
        String query = "SELECT username,password FROM (providers) ";

            statement = conn.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                String dbusername = result.getString("username");
                String dbpassword = result.getString("password");
                if(dbusername.equals(username) && dbpassword.equals(password)){
                    isRegistered = true;
                    break;
                }
                    
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        
        return isRegistered;
    }
    
    
    
}
