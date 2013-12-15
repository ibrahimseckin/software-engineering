/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package getServices.dao;

import getServices.util.Logger;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author TTISECKIN
 */
public class DaoConnect {

    public static Connection conn = null;
    
    private void logIt(String s) {
        Logger.logIt(s);
    }
    
    public  Statement connect() throws Exception {
        if(conn == null){
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://173.208.136.194:3306/test", "webapp", "webapp14");
        logIt("connection dondu");
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
    }
}