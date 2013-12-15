package getServices.dao;

import getServices.model.User;
import getServices.util.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            String query = "Insert into users" + "(firstname,surname,phoneno,email,address,age,city,username,password)"
                    + "values (?,?,?,?,?,?,?,?,?) ";

            pstatement = conn.prepareStatement(query);
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
    
    public int getUserId(String username, String password) {
        int userId = 0;
        try {
            String query = "SELECT  id from (users) WHERE username =? AND password =? ";
            pstatement = conn.prepareStatement(query);
            pstatement.setString(1, username);
            pstatement.setString(2, password);
            result = pstatement.executeQuery();

            if (result.next()) {
                userId = result.getInt(1);
            }
            return userId;

        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
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
    
    public User getOneUser(int inputId) {
        User user = new User();
        try {
            String query = "SELECT id,firstname,surname,email,address,age,city,username,phoneno from (users) "+
                    "where id=?";
            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, inputId);
            result = pstatement.executeQuery();
            
            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setFirstname(result.getString("firstname"));
                user.setSurname(result.getString("surname"));
                user.setEmail(result.getString("email"));
                user.setAddress(result.getString("address"));
                user.setCity(result.getString("city"));
                user.setUsername(result.getString("username"));
                user.setPhoneNumber(result.getString("phoneno"));
                
            }
        } 
        catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return user;
    }
    
}
