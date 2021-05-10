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
    
    public class NotUniqueException extends Exception{}
    
    public class NotFoundException extends Exception {}
    
    //toString method to display as a tree
    public String toString(){
        String treeDetails = new String();
        if (this.root != null) {
            treeDetails+=this.getTree(this.root,0);
        }
        else{
            treeDetails+="tree is empty";
        }
        return treeDetails;
    }
    
    private String getTree(PetBSTNode current, Integer level) {
        String treeDetails = new String();
        level++;
        if (current != null) {
            treeDetails += this.getTree(current.right, level);
            for (Integer i = 0; i < level; i++) {
                treeDetails += "    ";
            }
            treeDetails += current.pet + "\n";
            treeDetails += this.getTree(current.left, level);

        } else {
            for (Integer i = 0; i < level; i++) {
                treeDetails += "    ";
            }
            treeDetails += "null\n";
        }
        return treeDetails;
    }
    
    //Displaying the tree in alphabetical order
    public String displayInOrder(){
        String details = new String();
        
        if(this.root == null)
            details += "There are no pets in the system";
        else
            details += this.getInOrder(this.root) + "\n";

        return details;
    }
    
    private String getInOrder(PetBSTNode current){
        String inOrderDetails = new String();
        
        if (current != null) {
            inOrderDetails += this.getInOrder(current.left);
            inOrderDetails += current.pet + " ";
            inOrderDetails += this.getInOrder(current.right);
        }
        
        return inOrderDetails;
    }
    
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
    
    public Pet find(PetBSTNode petToFind) throws NotFoundException {
        return this.find(petToFind,this.root);
    }
    
    private Pet find(PetBSTNode petToFind, PetBSTNode current) throws NotFoundException{
    
        Pet foundObject;
        if (current != null) {
            if (petToFind.pet.compareTo(current.pet) == 0) {
                this.current=current;
                foundObject = current.pet;
            } else{
                this.parent=current;
                if (petToFind.pet.compareTo(current.pet) < 0) {
                    foundObject = this.find(petToFind,current.left);
                } else {
                    foundObject = this.find(petToFind,current.right);
                }
            }
        } else{
            throw new NotFoundException();
        }
        return foundObject;
    }
}
