/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.courseworkstep3;

/**
 *
 * @author Ross
 */
public class Product implements Comparable<Product>{
    private String productNumber;
    private String productName;
    private Integer quantity;
    
    public Product(String productNumber, String productName){
        this.productNumber = productNumber;
        this.productName = productName;
    }
    
    public void addQuantity(Integer quantity){
        this.quantity = quantity;
    }
    
    @Override
    public int compareTo(Product secondProduct){
        int compareTo = 0;
        
        if(this.productName.toLowerCase().compareTo(secondProduct.productName.toLowerCase()) < 0)
            compareTo = -1;
        else if(this.productName.toLowerCase().compareTo(secondProduct.productName.toLowerCase()) > 0)
            compareTo = 1;
        else{
            compareTo = 0;
        }
        
        if (compareTo == 0){
            if(this.productNumber.compareToIgnoreCase(secondProduct.productNumber) < 0){
                compareTo = -1;
            }else if(this.productNumber.compareToIgnoreCase(secondProduct.productNumber) > 0){
                compareTo = 1;
            }else{
                compareTo = 0;
            }
        }
        
        return compareTo;
    }
    
    public String toString(){
        String details = new String();
        
        details += "Product number: " + this.productNumber + "\n";  
        details += "Product name: " + this.productName + "\n";
        details += "Quantity: " + this.quantity + "\n";
        
        return details;
    }
}
