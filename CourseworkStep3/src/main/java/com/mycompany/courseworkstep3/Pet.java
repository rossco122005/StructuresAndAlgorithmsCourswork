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
public class Pet implements Comparable<Pet>{
    private String name;
    
    public Pet(String name){
        this.name = name;
    }
    
    public String toString(){
        String details = new String();
        
        details += this.name + " ";
        
        return details;
    }
    
    @Override
    public int compareTo(Pet secondPet){
        int compareTo = 0;
        
        if(this.name.toLowerCase().compareTo(secondPet.name.toLowerCase()) < 0)
            compareTo = -1;
        else if(this.name.toLowerCase().compareTo(secondPet.name.toLowerCase()) > 0)
            compareTo = 1;
        
        return compareTo;
    }
}
