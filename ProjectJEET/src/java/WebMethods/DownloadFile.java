/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebMethods;

import Beans.NewSessionBean;
import Beans.SessionBean;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author student
 */
@WebService(serviceName = "DownloadFile")
public class DownloadFile {

    /**
     * This is a sample web service operation
     */
    public String id;
    @Resource
    private WebServiceContext context;
    @EJB
    private NewSessionBean ejbRef;
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Downloading " + txt + " !";
    }
    @WebMethod(operationName = "Pobieranie")
        public void pobieranie() throws ServletException, IOException {
         MessageContext mc = context.getMessageContext();
         HttpServletRequest request = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
         HttpServletResponse response = (HttpServletResponse)mc.get(MessageContext.SERVLET_RESPONSE); 
    // Get the file ID from the request
    //int fileId = Integer.parseInt(request.getParameter("fileId"));

    // Connect to the database and retrieve the file data
    try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Sample", "admin", "123456");
        PreparedStatement stmt =
            conn.prepareStatement("SELECT name,file FROM files WHERE id = ?");) {
      stmt.setInt(1, 78101);
      try (ResultSet rs = stmt.executeQuery();) {
        if (rs.next()) {
          // Get the file name and data
          String fileName = rs.getString("name");
          Blob fileData = rs.getBlob("file");

          // Set the content type and header
          response.setContentType("application/octet-stream");
          response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

          // Write the data to the response output stream
        }
      }
    } catch (Exception e) {
      throw new ServletException("Error downloading file", e);
    }
  }
}

