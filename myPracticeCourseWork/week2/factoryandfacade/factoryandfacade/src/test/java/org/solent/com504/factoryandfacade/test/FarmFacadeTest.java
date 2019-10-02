package org.solent.com504.factoryandfacade.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.model.AnimalObjectFactory;
import org.solent.com504.factoryandfacade.model.FarmFacade;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author cgallen
 */
public class FarmFacadeTest {

    @Test
    public void FarmFacadeTest() {

        FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();
        assertNotNull(farmFacade);
        
        List<Animal> animalList = farmFacade.getAllAnimals();
        assertTrue(animalList.isEmpty());
         
        farmFacade.addCat("Pippa");
        farmFacade.addDog("Lehrer");
        farmFacade.addCow("Mootilda");
        
        animalList = farmFacade.getAllAnimals();
        
        assertEquals(animalList.get(0).getName(),"Pippa");
        assertEquals(animalList.get(1).getName(),"Lehrer");
        assertEquals(animalList.get(2).getName(),"Mootilda");
    }
}
