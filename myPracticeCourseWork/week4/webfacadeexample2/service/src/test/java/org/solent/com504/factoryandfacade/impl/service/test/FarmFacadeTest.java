/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.impl.service.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.impl.service.*;
import org.solent.com504.factoryandfacade.model.service.*;
import org.solent.com504.factoryandfacade.model.dto.*;

/**
 *
 * @author gallenc
 */
public class FarmFacadeTest {
    
    ServiceObjectFactory serviceObjectFactory = new ServiceObjectFactoryImpl();
    FarmFacade farmFacade = serviceObjectFactory.getFarmFacade();
    
    @Before
    public void setUpTest() {
        farmFacade.addAnimal("Cow", "Susan");
        farmFacade.addAnimal("Cat", "Paul");
        farmFacade.addAnimal("Dog", "Sam");
    }
    
    @Test
    public void getAnimalsTest() {
        assertEquals(farmFacade.getAllAnimals().size(), 3);
    }

    @Test
    public void InsertTest() {
        farmFacade.addAnimal("Cow", "Nancy");
        assertEquals(farmFacade.getAllAnimals().size(), 4);
        farmFacade.addAnimal("Cat", "Carl");
        assertEquals(farmFacade.getAllAnimals().size(), 5);
        farmFacade.addAnimal("Dog", "Terry");
        assertEquals(farmFacade.getAllAnimals().size(), 6);

    }
        
    @Test
    public void getAnimalsOfTypeTest() {
        assertEquals(farmFacade.getAnimalsOfType("Cow").size(), 1);
        assertEquals(farmFacade.getAnimalsOfType("Cat").size(), 1);
        assertEquals(farmFacade.getAnimalsOfType("Dog").size(), 1);
        
        farmFacade.addAnimal("Cow", "Nancy");
        farmFacade.addAnimal("Cat", "Carl");
        farmFacade.addAnimal("Dog", "Terry");
        
        assertEquals(farmFacade.getAnimalsOfType("Cow").size(), 2);
        assertEquals(farmFacade.getAnimalsOfType("Cat").size(), 2);
        assertEquals(farmFacade.getAnimalsOfType("Dog").size(), 2);
    }
    
    @Test
    public void getAnimalTest() {
        Animal animal = farmFacade.getAnimal("Susan");
        assertEquals(animal.getName(), "Susan");
        assertEquals(animal.getAnimalType().getType(), "Cow");

        animal = farmFacade.getAnimal("Paul");
        assertEquals(animal.getName(), "Paul");
        assertEquals(animal.getAnimalType().getType(), "Cat");
        
        animal = farmFacade.getAnimal("Sam");
        assertEquals(animal.getName(), "Sam");
        assertEquals(animal.getAnimalType().getType(), "Dog");
    }

    @Test
    public void removeAnimalTest() {
        farmFacade.removeAnimal("Susan");
        assertEquals(farmFacade.getAllAnimals().size(), 2);
        
        farmFacade.removeAnimal("Paul");
        assertEquals(farmFacade.getAllAnimals().size(), 1);
        
        farmFacade.removeAnimal("Sam");
        assertEquals(farmFacade.getAllAnimals().size(), 0);
    }

    @Test
    public void getSupportedAnimalTypesTest() {
        assertEquals(farmFacade.getSupportedAnimalTypes().size(), 3);
    }
}
