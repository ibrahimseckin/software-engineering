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

public class ProviderDao extends DaoConnect {
    
    PreparedStatement pstatement = null;
    Statement statement;
    ResultSet result;
    private Provider provider;
    
    private List<String> fieldList;
    private List<Provider> providerList;
    
    public ProviderDao() throws Exception {
        connect();
    }

    public void insertProvider(String pname, String phoneNumber, String email,
            String address, String city, String field, String username, String password) {
        try {
            
            String query = "Insert into providers" + "(pname,phoneno,email,address,city,field,username,password)"
                    + "values (?,?,?,?,?,?,?,?) ";

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
        
        public Provider getOneProvider(int inputId) {
            logIt("getOneprovider e girdi");
            provider = new Provider();
        
        try {
            String query = "SELECT id,pname,phoneno,email,address,city,rate,username,resume from (providers) "+
                    "where id=?";
            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, inputId);
            result = pstatement.executeQuery();
            
            while (result.next()) {
                getProvider().setId(result.getInt("id"));
                getProvider().setPname(result.getString("pname"));
                getProvider().setPhoneNumber(result.getString("phoneno"));
                getProvider().setEmail(result.getString("email"));
                getProvider().setAddress(result.getString("address"));
                getProvider().setCity(result.getString("city"));
                getProvider().setRate(result.getDouble("rate"));
                getProvider().setUsername(result.getString("username"));
                getProvider().setResume(result.getString("resume"));
                
            }
        } 
        catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return getProvider();
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
    
    
}
