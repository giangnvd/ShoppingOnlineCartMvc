/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductCart {

   private final List carlItems;
   public ProductCart(){
       carlItems = new ArrayList();
   }
   
   private List product;
   public List getProducts(){
       List temp = new ArrayList();
       try {
           String dbUser = "";
           String dbPassword = "";
           String url = "";
           Connection con = DriverManager.getConnection(,dbUser,dbPassword);
           Statement s = con.createStatement();
           Result
       } catch (Exception e) {
       }
       
    
}
}
