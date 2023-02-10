/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author student
 */
@WebService(serviceName = "SOAPtest")
public class SOAPtest extends HttpServlet{
    @EJB
    private SessionBean myBean;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Part filePart = request.getPart("file");
    InputStream fileContent = filePart.getInputStream();
    String name = filePart.getName();
    byte[] targetArray = new byte[fileContent.available()];

    fileContent.read(targetArray);
    Files file = new Files();
    file.setFile(targetArray);
    file.setName(name);
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJEETPU");
    EntityManager em = emf.createEntityManager();
    em.persist(file);

    em.getTransaction().commit();
    em.close();
  }
}
