package getServices.dao;

import getServices.model.Myfields;
import getServices.util.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author yiğido
 */
public class MyfieldsDao extends DaoConnect{
    
    PreparedStatement pstatement = null;
    Statement statement;
    ResultSet result;
    
    public MyfieldsDao() throws Exception {
        connect();
    }
    public List<String> getFields(int providerID){
        List<String> liste=new ArrayList<String>();
        try {  
            String query = "Select fields.name from myfields inner join fields on fields.id=myfields.fieldid where providerid = ?";
            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, providerID);
            result = pstatement.executeQuery();
            while(result.next())
            {
                liste.add(result.getString("fields.name"));
            }
            
  
   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }
}
