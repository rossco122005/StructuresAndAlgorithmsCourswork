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
public class ProductTest {
    public static void main(String[] args){
        Integer choice;
        
        ProductSortedLinkedList productLL = new ProductSortedLinkedList();

        do{
            System.out.println("0. Quit");
            System.out.println("1. Add a product");
            System.out.println("2. Find a product");
            System.out.println("3. Remove a product");
            System.out.println("4. Display all products in order");
            choice = Input.getInteger("Please choose: ");
            
            switch (choice){
                case 1:
                    System.out.println();
                    System.out.println("1. Add a product");
                    String newNumber = Input.getString("Enter the new product number: ");
                    String newName = Input.getString("Enter the new product name: ");
                    Integer newQuantity = Input.getInteger("Enter the qunatity of the new product");
                    Product newProduct = new Product(newNumber, newName);
                    newProduct.addQuantity(newQuantity);
                    
                    try{
                        productLL.addProduct(newProduct);
                    }catch(ProductSortedLinkedList.NotUniqueException e){
                        System.out.println("Product already exists");
                    }
                    
                    System.out.println();
                    
                    break;
                case 2:
                    System.out.println();
                    System.out.println("2. Find a product");
                    String findNumber = Input.getString("Enter the new product number: ");
                    String findName = Input.getString("Enter the new product name: ");
                    Product findProduct = new Product(findNumber, findName);
                    
                    try{
                        System.out.println(productLL.findProduct(findProduct));
                        System.out.println("The above product was found");
                    }catch(ProductSortedLinkedList.NotFoundException e){
                        System.out.println("Your product could not be found");
                    }
                    
                    System.out.println();
                    
                    break;
                case 3:
                    System.out.println();
                    System.out.println("3. Remove a product");
                    String removeNumber = Input.getString("Enter the product number to remove: ");
                    String removeName = Input.getString("Enter the product name you'd like to remove: ");
                    Product removeProduct = new Product(removeNumber, removeName);
                    
                    try{
                        productLL.remove(removeProduct);
                        System.out.println("Product removed");
                    }catch(ProductSortedLinkedList.NotFoundException e){
                        System.out.println("Your product could not be found");
                    }
                    
                    System.out.println();
                    
                    break;
                case 4:
                    System.out.println();
                    System.out.println("4. Display all products in order");
                    System.out.println(productLL);
                    
                    break;
                default:
                    if(choice == 0)
                        System.out.println("Quitting");
                    else
                        System.out.println("Invalid choice, please try again");
                    
                    break;
            }
            
        }while(choice != 0);
    }
}
