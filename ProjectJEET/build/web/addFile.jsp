<%-- 
    Document   : addFile
    Created on : 2023-01-30, 20:21:34
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File added succesfully</title>
    </head>
    <body>
        <jsp:useBean id="SessionBean" class="Beans.SessionBean"
  	scope="session"></jsp:useBean>
        <h1>Your file has been added! Or at least I hope so...</h1>
        <form action="mainPage.jsp">
    <input type="submit" value="wroc na strone glowna">
</form>

    </body>
</html>
