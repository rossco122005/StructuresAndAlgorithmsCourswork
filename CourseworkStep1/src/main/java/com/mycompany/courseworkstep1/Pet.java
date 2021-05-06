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
public class Pet {
    private String name;
    private BinarySearchTree petBST;
    
    public void createNewPet(String name){
        this.name = name;
    }
    
    public void addPetToTree(Pet pet)throws BinarySearchTree.NotUniqueException{
        this.petBST.insert(pet.name);
    }
    
    public String toString(){
        String details = new String();
        
        details += this.petBST.toString();
        
        return details;
    }
}
