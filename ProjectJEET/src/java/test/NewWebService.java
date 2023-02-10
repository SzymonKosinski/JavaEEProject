/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author student
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    
    @Resource
    private WebServiceContext context;
    @EJB
    private SessionBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "setInputValue")
    @Oneway
    public void setInputValue(@WebParam(name = "inputValue") String inputValue) {
        ejbRef.setInputValue(inputValue);
    }

    @WebMethod(operationName = "greetUser")
    public String greetUser(@WebParam(name = "name") String name) {
        return ejbRef.greetUser(name);
    }

    @WebMethod(operationName = "Dodaj")
    public void DoPost() throws ServletException, IOException {
         MessageContext mc = context.getMessageContext();
         HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
         ejbRef.Dodaj(req);
    }
    
}
