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
    
    public Pet find(Pet pet) throws NotFoundException {
        PetBSTNode petToFind = new PetBSTNode();
        petToFind.pet = pet;
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
    
    public Pet remove(Pet pet) throws NotFoundException {
        // sets up parent and current
        Pet removedObject=this.find(pet);
        if (this.current.left == null && this.current.right == null) {
            this.replaceNode(null);
        } else if (this.current.left != null && this.current.right == null) {
            this.replaceNode(this.current.left);
            this.current.left = null;
        } else if (this.current.left == null && this.current.right != null) {
            this.replaceNode(this.current.right);
            this.current.right = null;
        } else {
            this.replaceWithNextLargest(this.current, this.current, this.current.right);
        }
        return removedObject;
    }

    private void replaceNode(PetBSTNode replacement) {
        /* algorithm
            if current is root then 
                set root to replacement node
            else
                if current is the root of the left subtree of parent then
                    set parent's left subtreee to replacement node
                else
                    set parent's right subtree to replacement node
                end if
            end if
            set current object to null
         */
        if (this.current == this.root) // removing root
        {
            this.root = replacement;
        } else if (this.current == this.parent.left) {
            this.parent.left = replacement;
        } else {
            this.parent.right = replacement;
        }
        this.current.pet = null;
    }

    private void replaceWithNextLargest(PetBSTNode nodeForDeletion, PetBSTNode parent, PetBSTNode current) {
        /* Algorithm
            if current does not have a left subtree then
                copy the current object into the node for deletion
                if parent matches the node for deletion then
                    set parent's right subtree to be current's right subtree
                else
                    set parent's left subtree to be current's right subtree
                end if
                clear the current node
            else
                replace node for deletion with the next largest in current's left subtree
            end if
         */
        if (current.left == null) {
            nodeForDeletion.pet = current.pet;
            if (parent == nodeForDeletion) {
                parent.right = current.right;
            } else {
                parent.left = current.right;
            }
            current.pet = null;
            current.right = null;
        } else {
            this.replaceWithNextLargest(nodeForDeletion, current, current.left);
        }
    }
}
