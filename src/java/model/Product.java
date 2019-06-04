/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class Product {
    public  Product(){
        
    }
    
    public Product(int productId, String productName, String productType, float price){
    this.productId = productId;
    this.productName = productName;
    this.productType = productType;
    this.price = price;
    
    }
}
