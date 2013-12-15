/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getServices.dao;

import static getServices.dao.DaoConnect.conn;
import getServices.model.Offers;
import getServices.util.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samil.can
 */
public class OfferDao extends DaoConnect {
    
    PreparedStatement pstatement = null;
    Statement statement;
    ResultSet result;
    
    private List<Offers> offersList;
    
    private void logIt(String s) {
        Logger.logIt(s);
    }
    
    public OfferDao() throws Exception {
        connect();
    }
    
    public void insertOffer(int requestId, int providerId, int price ,
            String exp) {
        try {

            String query = "Insert into offers" + "(requestid,providerid,price,exp)"
                    + "values (?,?,?,?) ";

            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, requestId);
            pstatement.setInt(2, providerId);
            pstatement.setInt(3, price);
            pstatement.setString(4, exp);
            pstatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }
    
   public List<Offers> getOffers() {
        try {
            this.offersList = new ArrayList<Offers>();
            //logIt("sorgu yapti");
            String query = "SELECT id,requestid,providerid,price,exp from (offers) ";
            //logIt("sorgu calisti");

            statement = conn.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                //logIt("while'a girdi");
                //int dbUserId = result.getInt("userid");
                int requestId = result.getInt("requestid");
                int providerId = result.getInt("providerid");
                int price = result.getInt("price");
                String exp = result.getString("exp");
                        
                //if(dbUserId == userid)
                this.offersList.add(new Offers(requestId,providerId,price,exp));
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return this.offersList;
    }
    
    
}
