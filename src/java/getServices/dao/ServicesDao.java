/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getServices.dao;

import static getServices.dao.DaoConnect.conn;
import getServices.util.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ibrahim Seckin
 */
public class ServicesDao extends DaoConnect {

    PreparedStatement pstatement = null;
    Statement statement;
    ResultSet result;

    private void logIt(String s) {
        Logger.logIt(s);
    }

    public ServicesDao() throws Exception {
        connect();
    }

    public void insertProvider(String pname, String phoneNumber, String email,
            String address, String city, String field, String username, String password) {
        try {

            String query = "Insert into providers" + "(pname,phoneno,email,address,city,field,username,password)"
                    + "values (?,?,?,?,?,?,?,?,?) ";

            pstatement = conn.prepareStatement(query);
            pstatement.setString(1, pname);
            pstatement.setString(2, phoneNumber);
            pstatement.setString(3, email);
            pstatement.setString(4, address);
            pstatement.setString(5, city);
            pstatement.setString(6, field);
            pstatement.setString(7, username);
            pstatement.setString(8, password);
            pstatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }
}
