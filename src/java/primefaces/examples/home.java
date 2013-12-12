package primefaces.examples;

import java.io.Serializable;
import getServices.dao.DaoConnect;
import static getServices.dao.DaoConnect.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "home")
@ViewScoped

public class home implements Serializable {
    
    private String firstname;
    DaoConnect ns = new DaoConnect();
    PreparedStatement pstatement = null;
    Statement s;
    ResultSet r;
        public home() throws Exception {
            try{
            ns.connect();
            s = conn.createStatement();
            System.out.println("sorgu yapacak");
            r = s.executeQuery("SELECT id,name FROM (deneme)");
            System.out.println("sorgu yaptı");
            while(r.next()){
            System.out.println(r.getInt("id"));
            System.out.println(r.getString("name"));
            } 
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new UnsupportedOperationException(ex.getMessage());
        }
        }
    
        public String getFirstname() {
                return firstname;
        }
        
        public void setFirstname(String firstname) {
                this.firstname = firstname;
        }
    
}