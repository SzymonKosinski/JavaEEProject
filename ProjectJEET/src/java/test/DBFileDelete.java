/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(name = "DBFileDelete", urlPatterns = {"/DBFileDelete"})
public class DBFileDelete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String dbURL = "jdbc:derby://localhost:1527/Sample";
    private final String dbUser = "app";
    private final String dbPass = "123456";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        int uploadId = Integer.parseInt(request.getParameter("fileId"));
         
        Connection conn = null; // connection to the database
         
        try {
            // connects to the database
            //DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            // queries the database
            String sql = "DELETE FROM files WHERE id= ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, uploadId);
 
            statement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            response.getWriter().print("SQL Error: " + ex.getMessage());
    }
     if (conn != null) {
                // closes the database connection
     try {
      conn.close();
      } catch (SQLException ex) {
       ex.printStackTrace();
     
}
     }
     getServletContext().getRequestDispatcher("/ListOfFiles.jsp").forward(request, response);
        }
    }
}

