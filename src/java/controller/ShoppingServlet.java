/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProductCart;

/**
 *
 * @author admin
 */
public class ShoppingServlet extends HttpServer {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("shoppingError.jsp");
        }

        ProductCart bylist = (ProductCart) session.getAttribute("prod");
        String action = request.getParameter("action");

        if (!action.equals("CHECKOUT")) {
            if (action.equals("DELETE")) {
                int productId = Integer.parseInt(request.getParameter("delItem"));
                bylist.removeItem(productId);
            } else if (action.equals("ADD")) {
                if (bylist == null) {
                    bylist = new ProductCart();
                    addProduct(request, response, bylist);
                }
                session.setAttribute("prod", bylist);
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getNamedDispatcher("/index.jsp");
                rd.forward(request, response);
            } else if (action.equals("CHECKOUT")) {
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher('/checkout.jsp'
                );
                rd.forward(request, response);
            }
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response, ProductCart obj) {
        String myProd = request.getParameter("Product");
        String quantity = request.getParameter("qty");
        try {
            if (!validateQuantity(quantity)) {
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/ShoppingError.jsp");
                request.setAttribute('message'
                ,  
                 
                  
                 
                  
                 
                  
                 
                  
                 
                  
                 
                  
                 
                  
                 
                 'Quantity should  be a positive nonzero value.'
                );
            rd.forward(request, response);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringTokenizer t = new StringTokenizer(myProd, '|');
        Integer productId = new Integer(t.nextToken());
        String productName = t.nextToken();
        String productType = t.nextToken();
        Float price = new Float(t.nextToken());
        obj.addItem(productId.intValue(), productName, productType, price.floatValue(), Integer.parseInt(quantity));
    }

    private ServletContext getServletContext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean validateQuantity(String quantity) {
        boolean valid = false;
        for (int i = 0; i < quantity.length(); i++) {
            if ("0987654321".indexOf(quantity.charAt(i)) >= 0) {
                valid = true;
            } else {
                valid = false;
                break;
            }
        }
        if (!valid) {
            return false;
        } else if (Integer.parseInt(quantity) == 0) {
            return false;
            else
            return true;
        }
    }
}
