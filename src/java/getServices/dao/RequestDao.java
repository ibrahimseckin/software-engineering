package getServices.dao;

import static getServices.dao.DaoConnect.conn;
import getServices.model.Requests;
import getServices.util.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestDao extends DaoConnect {

    PreparedStatement pstatement = null;
    Statement statement;
    ResultSet result;
    
    private List<String> fieldList;
    private List<Requests> requestList;
    
    private void logIt(String s) {
        Logger.logIt(s);
    }

    public RequestDao() throws Exception {
        connect();
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }

    public void insertRequest(int userid, String field, Date timelimit,
            String city, double budget, String summary) {
        try {

            String query = "Insert into requests" + "(userid,field,reqdate,timelimit,city,budget,summary)"
                    + "values (?,?,?,?,?,?,?) ";

            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, userid);
            pstatement.setString(2, field);
            pstatement.setTimestamp(3, getCurrentTimeStamp());
            pstatement.setDate(4, (java.sql.Date) timelimit);
            pstatement.setString(5, city);
            pstatement.setDouble(6, budget);
            pstatement.setString(7, summary);
            pstatement.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }
    
    public Requests getOneRequest(int inputId) {
        Requests request = new Requests();
        try {
            String query = "SELECT * from (requests) "+
                    "where id=?";
            pstatement = conn.prepareStatement(query);
            pstatement.setInt(1, inputId);
            result = pstatement.executeQuery();
            
            while (result.next()) {
                request.setId(result.getInt("id"));
                request.setUserid(result.getInt("userid"));
                request.setField(result.getString("field"));
                request.setTimelimit(result.getDate("timelimit"));
                request.setCity(result.getString("city"));
                request.setBudget(result.getInt("budget"));
                request.setSummary(result.getString("summary"));
                request.setRequestDate(result.getDate("reqdate"));
            }
        } 
        catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return request;
    }
    
    public List<Requests> getRequest() {
        try {
            setRequestList(new ArrayList<Requests>());
            String query = "SELECT * from (requests) ";

            statement = conn.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                int userid = result.getInt("userid");
                String title = result.getString("title");
                String field = result.getString("field");
                Date reqdate = result.getDate("reqdate");
                Date timelimit = result.getDate("timelimit");
                String city = result.getString("city");
                Double budget = result.getDouble("budget");
                String summary = result.getString("summary");

                getRequestList().add(new Requests(id,userid,title,field,timelimit,reqdate,city,budget,summary));
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return getRequestList();
    }

    public List<String> getList() {
        try {
            setFieldList(new ArrayList<String>());
            String query = "SELECT field FROM (providers) ";

            statement = conn.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                logIt("while'a girdi");
                String field = result.getString("field");
                logIt("field:" + field);
                getFieldList().add(field);
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return getFieldList();
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Requests> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Requests> requestList) {
        this.requestList = requestList;
    }
}
