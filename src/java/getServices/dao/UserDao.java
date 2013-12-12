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
 * @author Ibrahim Seckin <your.name at your.org>
 */
public class UserDao extends DaoConnect {

    PreparedStatement pstatement = null;
    Statement statement;
    ResultSet result;
    
    private void logIt(String s) {
        Logger.logIt(s);
    }
    
    public UserDao() throws Exception {
        connect();
    }

    public void insertUser(String firstname, String surname, String phoneNumber, String email,
            String address, int age, String city, String username, String password) {
        try {
            /*logIt("insertUser cagirildi");
            //logIt("insert module gelen module id:" + module_id);
            logIt("firstname:" + firstname);
            logIt("surname:" + surname);
            logIt("phone:" + phoneNumber);
            logIt("email:" + email);
            logIt("address:" + address);
            logIt("age:" + age);
            logIt("city:" + city);
            logIt("username:" + username);
            logIt("password:" + password);
            */
            String query = "Insert into users" + "(firstname,surname,phoneno,email,address,age,city,username,password)"
                    + "values (?,?,?,?,?,?,?,?,?) ";

            //logIt("insert metod serviceid: " + serviceId);
            //logIt("insert metod modulename: " + moduleName);
            //logIt("insert metod employeeid: " + employeeId);
            //logIt("insert metod insertuser: " + insertUser);
            //logIt("insert metod status: " + status);
            pstatement = conn.prepareStatement(query);
            //pstatement.setInt(1, 1);
            pstatement.setString(1,firstname );
            pstatement.setString(2, surname);
            pstatement.setString(3, phoneNumber);
            pstatement.setString(4, email);
            pstatement.setString(5, address);
            pstatement.setInt(6, age);
            pstatement.setString(7, city);
            pstatement.setString(8, username);
            pstatement.setString(9, password);
            pstatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }
    
    public boolean isRegistered(String username, String password){
        boolean isRegistered = false;
        try{
            
        String query = "SELECT username,password FROM (users) ";

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
