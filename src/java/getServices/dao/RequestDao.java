/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Ibrahim Seckin
 */
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

    public List<Requests> getRequest() {
        try {
            logIt("getRequestList calisti");
            setRequestList(new ArrayList<Requests>());
            logIt("sorgu yapti");
            String query = "SELECT field,reqdate,timelimit,city,budget,summary from (requests) ";
            logIt("sorgu calisti");

            statement = conn.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                logIt("while'a girdi");
                //int dbUserId = result.getInt("userid");
                String field = result.getString("field");
                Date reqdate = result.getDate("reqdate");
                Date timelimit = result.getDate("timelimit");
                String city = result.getString("city");
                Double budget = result.getDouble("budget");
                String summary = result.getString("summary");
                        
                //if(dbUserId == userid)
                getRequestList().add(new Requests(field,timelimit,reqdate,city,budget,summary));
            }
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
        return getRequestList();
    }

    public List<String> getList() {
        try {
            logIt("getfieldList calisti");
            setFieldList(new ArrayList<String>());
            logIt("sorgu yapti");
            String query = "SELECT field FROM (providers) ";
            logIt("sorgu calisti");

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

    /**
     * @return the fieldList
     */
    public List<String> getFieldList() {
        return fieldList;
    }

    /**
     * @param fieldList the fieldList to set
     */
    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    /**
     * @return the requestList
     */
    public List<Requests> getRequestList() {
        return requestList;
    }

    /**
     * @param requestList the requestList to set
     */
    public void setRequestList(List<Requests> requestList) {
        this.requestList = requestList;
    }

}
