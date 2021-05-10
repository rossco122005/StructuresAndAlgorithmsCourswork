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
        
        PetBST petBST = new PetBST();

        do{
            System.out.println("0. Quit");
            System.out.println("1. Add a new pet type");
            System.out.println("2. Find if company supplies for a pet type");
            System.out.println("3. Display a specific pet type");
            System.out.println("4. Remove a pet type");
            System.out.println("5. Display all pet types in alphabetical order");
            System.out.println("6. Display the pets as a Binary Search Tree (for testing purposes)");
            choice = Input.getInteger("Please choose: ");
            
            switch (choice){
                case 1:
                    System.out.println();
                    //System.out.println("Add a new pet type");
                    String newPetName = Input.getString("Enter the new pet type you'd like to add: ");
                    Pet newPet = new Pet(newPetName);

                    try{
                        petBST.insert(newPet);
                    }catch(PetBST.NotUniqueException e){
                        System.out.println("This pet type already exists");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    //System.out.println("Find if company supplies for pet type");
                    String petToFind = Input.getString("Enter the type of pet you'd like to find: ");
                    Pet petToBeFound = new Pet(petToFind);
                    
                    try{
                        System.out.println("We supply products for the pet type: " + petBST.find(petToBeFound));
                    }catch(PetBST.NotFoundException e){
                        System.out.println("We do not currently supply for " + petToFind + "(s)");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Display a specific pet type");
                    break;
                case 4:
                    System.out.println();
                    //System.out.println("Remove a pet type");
                    String petToRemove = Input.getString("Enter the type of pet you'd like to remove: ");
                    Pet petToBeRemoved = new Pet(petToRemove);
                    
                    try{
                        petBST.remove(petToBeRemoved);
                        System.out.println(petToRemove + " has been removed");
                    }catch(PetBST.NotFoundException e){
                        System.out.println(petToRemove + " could not be found");
                    }
                    System.out.println();
                    break;
                case 5:
                    //System.out.println("Display all pet types in alphabetical order");
                    System.out.println("Here are all the pet types we supply for:");
                    System.out.println(petBST.displayInOrder());
                    break;
                case 6:
                    System.out.println("Display the pets as a Binary Search Tree");
                    System.out.println(petBST);
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            
        }while(choice != 0);
        
    }
}
