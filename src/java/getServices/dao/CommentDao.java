/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.dao;

import static getServices.dao.DaoConnect.conn;
import getServices.model.Comments;
import getServices.util.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Barbarossa
 */
public class CommentDao extends DaoConnect{
    PreparedStatement pstatement = null;
    Statement statement;
    ResultSet result;
    
    private void logIt(String s) {
        Logger.logIt(s);
    }
    
    public CommentDao() throws Exception
    {
        connect();
    }
    
    public void insertComment(int userid, int providerid, String content) {
        try {
            String query = "Insert into comments" + "(userid, providerid, content)"
                    + "values (?,?,?) ";

            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1,userid );
            pstatement.setInt(2, providerid);
            pstatement.setString(3, content);
            pstatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteComment(int id, int userid, int providerid, String comment) {
        try {
            String query = "DELETE from (comments) WHERE id =? AND userid =? AND providerid =? AND comment =?";
            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, id);
            pstatement.setInt(2, userid);
            pstatement.setInt(3, providerid);
            pstatement.setString(4, comment);
            result = pstatement.executeQuery();

            
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
    }
    
    public List<Comments> getProviderComments(int providerid) {
        try 
        {
            List<Comments> PComments = new ArrayList<Comments>(); 
            //String query = "SELECT * from (comments) where providerid =?";
            String query = "select comments.providerid, users.firstname, users.surname, users.username, comments.content " + 
                            "from users, comments " +
                            "where (users.id = comments.userid AND comments.providerid = ?)";
            
            
            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, providerid);
            result = pstatement.executeQuery();
            
            while (result.next()) {
                Comments comment = new Comments();
                comment.setProviderid(result.getInt("providerid"));
                comment.setFirstname(result.getString("firstname"));
                comment.setSurname(result.getString("surname"));
                comment.setUsername(result.getString("username"));
                comment.setContent(result.getString("content"));
                PComments.add(comment);
            }
            return PComments;
        } catch(SQLException ex) {
           throw new UnsupportedOperationException(ex.getMessage());
        }
        
    }
    
    public List<Comments> getAllComments() 
    {
        try 
        {
            List<Comments> PComments = new ArrayList<Comments>(); 
            String query = "select comments.providerid, users.firstname, users.surname, users.username, comments.content " +
"                           from users, comments " +
"                           where (users.id = comments.userid) ";
            
            statement = conn.createStatement();
            result = statement.executeQuery(query);
            
            while (result.next()) {
                Comments comment = new Comments();
                comment.setProviderid(result.getInt("providerid"));
                comment.setFirstname(result.getString("firstname"));
                comment.setSurname(result.getString("surname"));
                comment.setUsername(result.getString("username"));
                comment.setContent(result.getString("content"));
                PComments.add(comment);
            }
            return PComments;
        } catch(SQLException ex) {
           throw new UnsupportedOperationException(ex.getMessage());
        }
    }
    
}
