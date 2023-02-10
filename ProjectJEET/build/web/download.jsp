<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : download
    Created on : 2023-01-31, 09:20:51
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
   String variable1 = request.getParameter("downloadID");
%>
    <jsp:useBean id="bean1" class="WebMethods.DownloadFile"
    scope="session">
    </jsp:useBean>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Downloading...</title>
    </head>
    <body>
        hello: <%=variable1%>
        ${bean1.hello(param.variable1)}
    </body>
</html>
