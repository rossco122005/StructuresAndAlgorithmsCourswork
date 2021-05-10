/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.courseworkstep2;

/**
 *
 * @author Ross
 */
public class Product implements Comparable<Product>{
    private String productNumber;
    private String productName;
    private Integer quantity;
    
    public Product(String productName){
        this.productNumber = null;
        this.productName = productName;
        this.quantity = 0;
    }
    
    @Override
    public int compareTo(Product secondProduct){
        int compareTo = 0;
        
        if(this.productName.toLowerCase().compareTo(secondProduct.productName.toLowerCase()) < 0)
            compareTo = -1;
        else if(this.productName.toLowerCase().compareTo(secondProduct.productName.toLowerCase()) > 0)
            compareTo = 1;
        
        return compareTo;
    }
    
    public String toString(){
        String details = new String();
        
        details += this.productNumber + "\n" + this.productName + "\n" + this.quantity + "\n";
        
        return details;
    }
}
