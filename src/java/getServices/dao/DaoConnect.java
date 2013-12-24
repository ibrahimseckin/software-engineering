package getServices.dao;

import getServices.util.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoConnect {

    public static Connection conn = null;
    
    private void logIt(String s) {
        Logger.logIt(s);
    }
    
    public  Statement connect() throws Exception {
        if(conn == null){
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://173.208.136.194:3306/test?useUnicode=true&amp;characterEncoding=utf8", "webapp", "webapp14");
        Statement st1 = conn.createStatement();
        
        //st1.executeQuery("SET NAMES 'utf8'"); 
        //st1.executeQuery("SET CHARACTER SET utf8mb4"); 
        //st1.executeQuery("SET COLLATION_CONNECTION = 'utf8mb4_turkish_ci'"); 
        
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
}