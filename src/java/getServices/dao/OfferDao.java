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
            String query = "SELECT id,requestid,providerid,price,exp,selected from (offers) ";
            //logIt("sorgu calisti");

            statement = conn.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                int requestId = result.getInt("requestid");
                int providerId = result.getInt("providerid");
                int price = result.getInt("price");
                String exp = result.getString("exp");
                boolean selected = result.getBoolean("selected");
                int id = result.getInt("id");
                        
                //if(dbUserId == userid)
                this.offersList.add(new Offers(id,requestId,providerId,price,exp,selected));
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return this.offersList;
    }
   
   public List<Offers> getOffers(int providerId) {
        try {
            this.offersList = new ArrayList<Offers>();
            String query = "SELECT id,requestid,providerid,price,exp,accepted from (offers) where providerid = ? ";

            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, providerId);
            result = pstatement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                int requestid = result.getInt("requestid");
                int providerid = result.getInt("providerid");
                int price = result.getInt("price");
                String exp = result.getString("exp");
                boolean selected = result.getBoolean("accepted");

                this.offersList.add(new Offers(id, requestid, providerid, price, exp, selected));
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return this.offersList;
    }
    
    public List<Offers> getOffersToRequest(int requestid){
        try {
            this.offersList = new ArrayList<Offers>();
            String query = "SELECT * from requests where id="+requestid;

            statement = conn.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                int requestId = result.getInt("requestid");
                int providerId = result.getInt("providerid");
                int price = result.getInt("price");
                String exp = result.getString("exp");
                boolean selected = result.getBoolean("selected");
                int id = result.getInt("id");
                this.offersList.add(new Offers(id,requestId,providerId,price,exp,selected));
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return this.offersList;
    }
    
}
