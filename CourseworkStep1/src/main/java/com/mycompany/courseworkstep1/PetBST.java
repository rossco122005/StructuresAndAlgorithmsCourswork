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
public class PetBST {
    private class PetBSTNode{
        private Pet pet;
        private PetBSTNode left;
        private PetBSTNode right;
    }
    
    private PetBSTNode root;
    private PetBSTNode current;
    private PetBSTNode parent;
    
    public String toString(){
        String details = new String();
        
        if(this.root == null)
            details += "There are currently no pet types";
        else
            details += "There are currently no pet types";
        
        return details;
    }
    
    public class NotUniqueException extends Exception{}
    
    public void insert(Pet pet) throws NotUniqueException{
        PetBSTNode newNode = new PetBSTNode();
        newNode.pet = pet;
        if(this.root == null)
            this.root = newNode;
        else{
            this.insert(newNode, this.root);
        }     
    }
    
    private void insert(PetBSTNode newNode, PetBSTNode current) throws NotUniqueException{
        if(newNode.pet.compareTo(current.pet) == 0)
            throw new NotUniqueException();
        
        if(newNode.pet.compareTo(current.pet) < 0){
            if(current.left == null){
                current.left = newNode;
            }else{
                this.insert(newNode,current.left);
            }   
        }else if(current.right == null){
            current.right = newNode;
        }else{
            this.insert(newNode,current.right);
        }
    }
}
