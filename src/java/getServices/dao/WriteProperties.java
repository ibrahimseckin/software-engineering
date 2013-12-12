/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package getServices.dao;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author TTISECKIN
 */
public class WriteProperties {

    Properties prop = new Properties();



    public WriteProperties() throws Exception {
        try {
            //set the properties value
            prop.setProperty("serverName", "173.208.136.194");
            prop.setProperty("sid", "test");
            prop.setProperty("port", "3306");
            prop.setProperty("dbuser", "webapp");
            prop.setProperty("dbpassword", "webapp14");

            //save properties to project root folder
            prop.store(new FileOutputStream("config.properties"), null);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
