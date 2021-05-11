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
public class Step3Test {
    public static void main(String[] args){
        Integer choice;
        
        PetBSTWithLL petSupplies = new PetBSTWithLL();

        do{
            System.out.println("0. Quit");
            System.out.println("1. Add a new pet type");
            System.out.println("2. Add a new product for a specific pet");
            System.out.println("3. Find if company supplies for a specific pet type");
            System.out.println("4. Display all pet types the company stocks for");
            System.out.println("5. Display all products for a specific pet type");
            System.out.println("6. Display all pets and the products stocked for them");
            System.out.println("7. Remove a specific product for a specific pet type");
            System.out.println("8. Remove a pet from the system");
            choice = Input.getInteger("Please choose: ");
            
            switch (choice){
                case 1:
                    System.out.println();
                    System.out.println("1. Add a new pet type");
                    String newPetName = Input.getString("Enter the new pet type you'd like to add: ");
                    Pet newPet = new Pet(newPetName);

                    try{
                        petSupplies.insert(newPet);
                    }catch(PetBSTWithLL.NotUniqueException e){
                        System.out.println("This pet type already exists");
                    }
                    System.out.println();
                    
                    break;
                case 2:
                    System.out.println();
                    System.out.println("2. Add a new product for a specific pet");
                    
                    Boolean petFound = false;
                    String petToFind = Input.getString("Enter the type of pet you'd like to find: ");
                    Pet petToAddProductTo = new Pet(petToFind);
                    
                    try{
                        petSupplies.find(petToAddProductTo);
                        System.out.println("Pet found");
                        petFound = true;
                    }catch(PetBSTWithLL.NotFoundException e){
                        System.out.println("We currently do not stock for " + petToFind + "(s)");
                    }
                    
                    if(petFound){
                        String newProductNumber = Input.getString("Enter the new product number: ");
                        String newProductName = Input.getString("Enter the new product name: ");
                        Integer newProductQuantity = Input.getInteger("Enter the qunatity of the new product");
                        Product newProduct = new Product(newProductNumber, newProductName);
                        newProduct.addQuantity(newProductQuantity);

                        try{
                            petSupplies.addProductToPet(newProduct);
                            System.out.println("Product added");
                        }catch(PetBSTWithLL.NotUniqueException e){
                            System.out.println("Product already exists for pet");
                        }
                    }

                    System.out.println();
                    
                    break;
                case 3:
                    System.out.println();
                    System.out.println("3. Find if company supplies for a specific pet type");
                    String petToFindName = Input.getString("Enter the type of pet you'd like to find: ");
                    Pet petToBeFound = new Pet(petToFindName);
                    
                    try{
                        petSupplies.find(petToBeFound);
                        System.out.println("The company does currently supply for the pet type: " + petToBeFound);
                    }catch(PetBSTWithLL.NotFoundException e){
                        System.out.println("The company currently does not stock for the pet type: " + petToBeFound + "(s)");
                    }
                    
                    System.out.println();
                    
                    break;
                case 4:
                    System.out.println();
                    System.out.println("4. Display all pet types the company stocks for");
                    System.out.println("Here are all the pet types the company stocks for: ");
                    System.out.println(petSupplies.displayInOrder());
                    
                    break;
                case 5:
                    System.out.println();
                    System.out.println("5. Display all products for a specific pet type");
                    
                    Boolean petFoundForProductDisplay = false;
                    String petToFindForProductDisplay = Input.getString("Enter the type of pet you'd like to find: ");
                    Pet petToDisplayProducts = new Pet(petToFindForProductDisplay);
                    
                    try{
                        petSupplies.find(petToDisplayProducts);
                        petFoundForProductDisplay = true;
                    }catch(PetBSTWithLL.NotFoundException e){
                        System.out.println("We currently do not stock for " + petToDisplayProducts + "(s)");
                    }
                    
                    if(petFoundForProductDisplay)
                        System.out.println(petSupplies.displayProductsForPet());
                   
                    break;
                case 6:
                    System.out.println();
                    System.out.println("6. Display all pets and the products stocked for them");
                    System.out.println();
                    System.out.println(petSupplies.displayAllPetsAndProducts());
                    
                    
                    break;
                case 7:
                    System.out.println();
                    System.out.println("7. Remove a specific product for a specific pet type");
                    
                    Boolean petFoundForProductRemove = false;
                    String petToFindForProductRemove = Input.getString("Enter the type of pet you'd like to find: ");
                    Pet petToFindToRemoveProduct = new Pet(petToFindForProductRemove);
                    
                    try{
                        petSupplies.find(petToFindToRemoveProduct);
                        petFoundForProductRemove = true;
                    }catch(PetBSTWithLL.NotFoundException e){
                        System.out.println("We currently do not stock for " + petToFindToRemoveProduct + "(s)");
                    }
                    
                    if(petFoundForProductRemove){
                        String removeProductNumber = Input.getString("Enter the product number you'd like to remove: ");
                        String removeProductName = Input.getString("Enter the product name you'd like to remove: ");
                        Product removeProduct = new Product(removeProductNumber, removeProductName);
                        
                        try{
                            petSupplies.removeProductFromPet(removeProduct);
                            System.out.println("Product removed");
                        }catch(PetBSTWithLL.NotFoundException e){
                            System.out.println("Product was not found");
                        }
                    }
                    
                    System.out.println();
                    
                    break;
                case 8:
                    System.out.println();
                    System.out.println("8. Remove a pet from the system");
                    String petToRemove = Input.getString("Enter the type of pet you'd like to remove: ");
                    Pet petToBeRemoved = new Pet(petToRemove);
                    
                    try{
                        petSupplies.remove(petToBeRemoved);
                        System.out.println(petToRemove + " has been removed");
                    }catch(PetBSTWithLL.NotFoundException e){
                        System.out.println(petToRemove + " are not on the system");
                    }
                    System.out.println();
                    
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
