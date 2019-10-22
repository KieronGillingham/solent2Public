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
        farmFacade.addAnimal("Duck", "Travis");
        farmFacade.addAnimal("Sheep", "Miriam");
    }
    
    @Test
    public void getAnimalsTest() {
        assertEquals(farmFacade.getAllAnimals().size(), 5);
    }

    @Test
    public void InsertTest() {
        farmFacade.addAnimal("Cow", "Nancy");
        assertEquals(farmFacade.getAllAnimals().size(), 6);
        farmFacade.addAnimal("Cat", "Carl");
        assertEquals(farmFacade.getAllAnimals().size(), 7);
        farmFacade.addAnimal("Dog", "Terry");
        assertEquals(farmFacade.getAllAnimals().size(), 8);
        farmFacade.addAnimal("Duck", "Queenie");
        assertEquals(farmFacade.getAllAnimals().size(), 9);
        farmFacade.addAnimal("Sheep", "Sarah");
        assertEquals(farmFacade.getAllAnimals().size(), 10);

    }
        
    @Test
    public void getAnimalsOfTypeTest() {
        assertEquals(farmFacade.getAnimalsOfType("Cow").size(), 1);
        assertEquals(farmFacade.getAnimalsOfType("Cat").size(), 1);
        assertEquals(farmFacade.getAnimalsOfType("Dog").size(), 1);
        assertEquals(farmFacade.getAnimalsOfType("Duck").size(), 1);
        assertEquals(farmFacade.getAnimalsOfType("Sheep").size(), 1);
        
        farmFacade.addAnimal("Cow", "Nancy");
        farmFacade.addAnimal("Cat", "Carl");
        farmFacade.addAnimal("Dog", "Terry");
        farmFacade.addAnimal("Duck", "Queenie");
        farmFacade.addAnimal("Sheep", "Sarah");
        
        assertEquals(farmFacade.getAnimalsOfType("Cow").size(), 2);
        assertEquals(farmFacade.getAnimalsOfType("Cat").size(), 2);
        assertEquals(farmFacade.getAnimalsOfType("Dog").size(), 2);
        assertEquals(farmFacade.getAnimalsOfType("Duck").size(), 2);
        assertEquals(farmFacade.getAnimalsOfType("Sheep").size(), 2);
    }
    
    @Test
    public void getAnimalTest() {
        Animal animal = farmFacade.getAnimal("Susan");
        assertEquals(animal.getName(), "Susan");
        assertEquals(animal.getAnimalType().getType(), "Cow");
        assertEquals(animal.getAnimalType().getSound(), "moo");

        animal = farmFacade.getAnimal("Paul");
        assertEquals(animal.getName(), "Paul");
        assertEquals(animal.getAnimalType().getType(), "Cat");
        assertEquals(animal.getAnimalType().getSound(), "meow");
        
        animal = farmFacade.getAnimal("Sam");
        assertEquals(animal.getName(), "Sam");
        assertEquals(animal.getAnimalType().getType(), "Dog");
        assertEquals(animal.getAnimalType().getSound(), "woof");
        
        animal = farmFacade.getAnimal("Travis");
        assertEquals(animal.getName(), "Travis");
        assertEquals(animal.getAnimalType().getType(), "Duck");
        assertEquals(animal.getAnimalType().getSound(), "quack");
        
        animal = farmFacade.getAnimal("Miriam");
        assertEquals(animal.getName(), "Miriam");
        assertEquals(animal.getAnimalType().getType(), "Sheep");
        assertEquals(animal.getAnimalType().getSound(), "baaa");
    }

    @Test
    public void removeAnimalTest() {
        farmFacade.removeAnimal("Susan");
        assertEquals(farmFacade.getAllAnimals().size(), 4);
        
        farmFacade.removeAnimal("Paul");
        assertEquals(farmFacade.getAllAnimals().size(), 3);
        
        farmFacade.removeAnimal("Sam");
        assertEquals(farmFacade.getAllAnimals().size(), 2);
        
        farmFacade.removeAnimal("Travis");
        assertEquals(farmFacade.getAllAnimals().size(), 1);
        
        farmFacade.removeAnimal("Miriam");
        assertEquals(farmFacade.getAllAnimals().size(), 0);
    }

    @Test
    public void getSupportedAnimalTypesTest() {
        assertEquals(farmFacade.getSupportedAnimalTypes().size(), 5);
    }
}