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

        Properties prop = new Properties();
        prop.load(new FileInputStream("config.properties"));

        String serverName = prop.getProperty("serverName");//server ip
        //logIt("servername:" + serverName);
        String sid = "test";
        //prop.getProperty("sid");//dbname
        //logIt("sid:" + sid);
        String url = "jdbc:mysql://" + serverName + ":" + prop.getProperty("port")+"/" + sid;
        String properties= "?useUnicode=true&amp;characterEncoding=utf8"; //Türkçe karakter problemi yaşamamak için
        String databaseUser = prop.getProperty("dbuser");
        //logIt("dbuser:" + databaseUser);
        String databasePassword = prop.getProperty("dbpassword");
        //logIt("dbpassword:" + databasePassword);
        Class.forName("com.mysql.jdbc.Driver");
        //logIt("driver okundu");
        conn = DriverManager.getConnection(url, databaseUser, databasePassword);
        logIt("connection dondu");
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
    }
}