/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.courseworkstep3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ross
 */
public class PetBSTWithLLTest {
    
    public PetBSTWithLLTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of insert method, of class PetBSTWithLL.
     */
    @Test
    public void testInsertPetToBST() throws Exception {
        System.out.println("insert");
        Pet petCat = new Pet("cat");
        PetBSTWithLL instance = new PetBSTWithLL();
        
        //Inserting the Pet cat
        instance.insert(petCat);
        
        try{
            //Inserting the Pet cat to check for NotUniqueException
            instance.insert(petCat);
            fail("The pet cat was able to be added again. Test fail.");
        }catch(PetBSTWithLL.NotUniqueException nue1){
            //Test passed
        }
        
        Pet petDog = new Pet("dog");
        //Inserting the Pet dog
        instance.insert(petDog);
        
        try{
            //Inserting the Pet dog to check for NotUniqueException
            instance.insert(petDog);
            fail("The dog cat was able to be added again. Test fail.");
        }catch(PetBSTWithLL.NotUniqueException nue2){
            //Test passed
        }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class PetBSTWithLL.
     */
    @Test
    public void testFindPet() throws Exception {
        System.out.println("find");
        
        Pet pet = new Pet("fish");
        PetBSTWithLL instance = new PetBSTWithLL();
        instance.insert(pet);
        
        //Inserting other pets to show that a pet can be found with multiple pets in the BST
        Pet pet1 = new Pet("dog");
        Pet pet2 = new Pet("reptile");
        Pet pet3 = new Pet("monkey");
        Pet pet4 = new Pet("cat");
        
        instance.insert(pet1);
        instance.insert(pet2);
        instance.insert(pet3);
        instance.insert(pet4);
        
        Pet expResult = new Pet("fish");
        Pet result = instance.find(pet);
        assertEquals(expResult, result);
        
        try{
            Pet petForExceptionTest = new Pet("insect");
            instance.find(petForExceptionTest);
            fail("Pet was found when it should not have been");
        }catch(PetBSTWithLL.NotFoundException nfe){
            //Test passed as the pet was not found
        }

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class PetBSTWithLL.
     */
    @Test
    public void testRemovePetFromBST() throws Exception {
        System.out.println("remove");
        Pet testPet = new Pet("dog");
        PetBSTWithLL instance = new PetBSTWithLL();
        instance.insert(testPet);
        Pet expResult = new Pet("dog");
        Pet result = instance.remove(testPet);
        assertEquals(expResult, result);
        
        try{
            instance.remove(testPet);
            fail("The Pet wasn't removed from the Binary Search Tree");
        }catch(PetBSTWithLL.NotFoundException nfe){
            //Test passed as pet was removed
        }

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addProductToPet method, of class PetBSTWithLL.
     */
    @Test
    public void testAddProductToPet() throws Exception {
        System.out.println("addProductToPet");
        Pet testPet = new Pet("dog");
        Product product = new Product("P001", "bowl");
        PetBSTWithLL instance = new PetBSTWithLL();
        
        //Insert pet to add the product to
        instance.insert(testPet);
        //Finding the pet to add the product to
        instance.find(testPet);
        //Adding the product to the pet
        instance.addProductToPet(product);
        
        try{
            //Trying to add the product again to check for NotUniqueException
            instance.addProductToPet(product);
            //Fail as the product was able to be added again
            fail("Product was able to be added again");
        }catch(PetBSTWithLL.NotUniqueException nue){
            //Test passed as product not added again
        }

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeProductFromPet method, of class PetBSTWithLL.
     */
    @Test
    public void testRemoveProductFromPet() throws Exception {
        System.out.println("removeProductFromPet");
        Pet testPet = new Pet("dog");
        Product product = new Product("P001", "bowl");
        PetBSTWithLL instance = new PetBSTWithLL();
        
        //Adding pet to add product to
        instance.insert(testPet);
        //Finding pet to add product to
        instance.find(testPet);
        //Adding product to pet
        instance.addProductToPet(product);
            
        //Removing the product from the pet
        instance.removeProductFromPet(product);
        
        try{
            instance.removeProductFromPet(product);
            fail("Product was able to be removed again");
        }catch(PetBSTWithLL.NotFoundException nfe){
            //Test passed as product was not found
        }

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
