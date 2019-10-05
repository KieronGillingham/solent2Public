package org.solent.com504.factoryandfacade.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.model.*;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author cgallen
 */
public class FarmFacadeTest {

    FarmFacade farmFacade;
    List<Animal> animalList;
    
    @Before
    public void CreateFarmFacade()
    {
        farmFacade = AnimalObjectFactory.createFarmFacade();
        animalList = farmFacade.getAllAnimals();
    }
    
    @Test
    public void InitialiseListTest()
    {
        farmFacade = AnimalObjectFactory.createFarmFacade();
        // Check FarmFacade has been created
        assertNotNull(farmFacade);
        
        // Check list of animals is initially empty
        animalList = farmFacade.getAllAnimals();
        assertTrue(animalList.isEmpty());
    }
    
    @Test
    public void AddAnimalsTest() {

        farmFacade.addCat("Pippa");
        farmFacade.addDog("Lehrer");
        farmFacade.addCow("Mootilda");
        farmFacade.addDuck("Psy");
        
        animalList = farmFacade.getAllAnimals();
        
        assertEquals(animalList.get(0).getName(),"Pippa");
        assertEquals(animalList.get(1).getName(),"Lehrer");
        assertEquals(animalList.get(2).getName(),"Mootilda");
        assertEquals(animalList.get(3).getName(),"Psy");
    }
    
    @Test
    public void AddAnimalsTest2() {

        farmFacade.addCat("Fido");
        
        animalList = farmFacade.getAllAnimals();
        
        assertNotEquals(animalList.get(0).getName(),"A cat name");
    }
    

    
}
