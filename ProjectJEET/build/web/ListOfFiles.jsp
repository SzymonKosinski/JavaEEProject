<%-- 
    Document   : ListOfFiles
    Created on : 2023-01-30, 23:08:50
    Author     : student
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of uploaded .doc files</h1>
                <jsp:useBean id="bean1" class="Beans.NewSessionBean"
  	scope="session"></jsp:useBean>
    <!--bardzo brzydki fragment kodu-->                 
<%
      try {
          /* Create string of connection url within specified format with machine name, port number and database name. Here machine name id localhost and database name is student. */
          String connectionURL = "jdbc:derby://localhost:1527/Sample";

          // declare a connection by using Connection interface
          Connection connection = null;

          // declare object of Statement interface that is used for executing sql statements.
          Statement statement = null;

          // declare a resultset that uses as a table for output data from tha table.
          ResultSet rs = null;

          // Load JBBC driver "com.mysql.jdbc.Driver"
          Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

          /* Create a connection by using getConnection() method that takes parameters of string type connection url, user name and password to connect to database. */
          connection = DriverManager.getConnection(connectionURL, "app", "123456");

          /* createStatement() is used for create statement object that is used for sending sql statements
          to the specified database. */
          statement = connection.createStatement();

          // sql query to retrieve values from the secified table.
          String QueryString = "SELECT * from Files";
          rs = statement.executeQuery(QueryString);
%>
                <div align="center">
        <table border="2" cellpadding="6">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>file</th>
                <th>download link</th>
                <th>delete file</th>
            </tr>
              
<%  
    while (rs.next()) {
    %>
                 <tr>
        <%int id= rs.getInt(1);%>
        <TD><%=id%></TD>
        <TD><%=rs.getString(2)%></TD>
        <TD><form action="ReadDescriptionServlet" method="GET">
        <input type="hidden" id="fileId" name="fileId" value = "<%=id%>">
        <input type="submit" value="read description">
        </form></td>
    <TD><form action ="DBFileDownloadServlet" method="GET">
    <input type="hidden" id="fileId" name="fileId" value = "<%=id%>">
    <input type="submit" value="Download">
    </form></td>
        </form></td>
        <TD><form action="DBFileDelete" method="GET">
        <input type="hidden" id="fileId" name="fileId" value = "<%=id%>">
        <input type="submit" value="delete file">
        </form></td>
                 </tr>
          <%   }    %>
            </table>
            
            <%
                // close all the connections.
    rs.close();
    statement.close();
    connection.close();
} catch (Exception ex) {
    %>
    </font>
    <font size="+3" color="red"></b>
        <%
                out.println("Unable to connect to database.");
            }
        %>
        
    </div>
            <form action="mainPage.jsp">
    <input type="submit" value="wroc na strone glowna">
</form>
    </body>
</html>
