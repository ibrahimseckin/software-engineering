package getServices.dao;

import static getServices.dao.DaoConnect.conn;
import getServices.model.Offers;
import getServices.model.Provider;
import getServices.model.Requests;
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
            String query = "SELECT *"
                    + " from offers INNER JOIN requests on offers.requestid = requests.id"
                    + " where providerid = ? ";

            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, providerId);
            result = pstatement.executeQuery();

            if (result.next()) {
                int id = result.getInt("offers.id");
                int requestid = result.getInt("requestid");
                int providerid = result.getInt("providerid");
                int price = result.getInt("price");
                String exp = result.getString("exp");
                boolean selected = result.getBoolean("accepted");
                Offers offer = new Offers(id, requestid, providerid, price, exp, selected);
                Requests request = new Requests();
                request.setTitle(result.getString("requests.title"));
                offer.setRequest(request);
                this.offersList.add(offer);
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return this.offersList;
    }
    
    public List<Offers> getOffersToRequest(int requestid){
        try {
            this.offersList = new ArrayList<Offers>();
            String query = "SELECT * from offers " +
                            "INNER JOIN providers " +
                            "ON offers.providerid = providers.id where requestid=" + requestid;
                           //+ "and request.providerid = provider.id";

            statement = conn.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                Offers offer = new Offers();
                Provider provider;
                provider = new Provider(result.getInt("providers.id"),result.getString("pname"),result.getString("phoneno"),result.getString("email"),result.getString("address"),result.getString("city"),result.getDouble("rate"),result.getString("resume"));
                offer.setRequestId(result.getInt("requestid"));
                offer.setproviderId(result.getInt("providerid"));
                offer.setPrice(result.getInt("price"));
                offer.setExp(result.getString("exp"));
                offer.setSelected(result.getBoolean("accepted"));
                offer.setId(result.getInt("offers.id"));
                offer.setProvider(provider);
                
                this.offersList.add(offer);
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return this.offersList;
    }
    
        public void acceptOffer(int offerid, int requestid){
        try {
            String query = "UPDATE requests SET selected = "+offerid
                    + " where id ="+requestid;
            
            logIt("Request id is "+requestid);
            logIt("Offer id is "+offerid);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            query = "UPDATE offers SET accepted = "+true+" where id ="+offerid;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
}
