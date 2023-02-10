/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebMethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateful;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author student
 */
@WebService(serviceName = "NewWebService1")
@Stateful()
public class ListingFiles {

    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    @WebMethod(operationName="ShowFiles")
    public String ShowFiles() throws SQLException
    {
    String query = "SELECT * FROM Files";

    //Class.forName("com.mysql.jdbc.Driver").newInstance();
    String url = "jdbc:derby://localhost:1527/Sample";
    Connection conn = DriverManager.getConnection(url, "app", "123456");
    Statement stmt = conn.createStatement();

    ResultSet rs;
    rs = stmt.executeQuery(query);

    String result = "";

    while (rs.next()) {
        result += rs.getString("name");
    }
    return result;
    }
}
