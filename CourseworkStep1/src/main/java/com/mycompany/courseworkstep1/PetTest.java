/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.courseworkstep1;

/**
 *
 * @author Ross
 */
public class PetTest {
    public static void main(String[] args){
        Integer choice;
        
        
        
        do{
            System.out.println("0. Quit");
            System.out.println("1. Add a new pet type");
            System.out.println("2. Find if company supplies for pet type");
            System.out.println("3. Display a specific pet type");
            System.out.println("4. Remove a pet type");
            System.out.println("5. Display all pet types");
            choice = Input.getInteger("Please choose: ");
            
            switch (choice){
                case 1:
                    System.out.println("Add a new pet type");
                    Pet newPet = new Pet();
                    String newPetName = Input.getString("Enter the new pet type");
                    newPet.createNewPet(newPetName);
                    try{
                        newPet.addPetToTree(newPet);
                    }catch(SortedADT.NotUniqueException e){
                        System.out.println("Pet type already exists");
                    }
                    
                    
                    break;
                case 2:
                    System.out.println("Find if company sullpes for pet type");
                    break;
                case 3:
                    System.out.println("Display a specific pet type");
                    break;
                case 4:
                    System.out.println("Remove a pet type");
                    break;
                case 5:
                    System.out.println("Display all pet types");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            
        }while(choice != 0);
        
    }
}
