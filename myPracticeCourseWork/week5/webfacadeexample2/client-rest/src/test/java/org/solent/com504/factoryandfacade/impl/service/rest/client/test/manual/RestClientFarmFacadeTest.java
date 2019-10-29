/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.impl.service.rest.client.test.manual;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.factoryandfacade.impl.service.rest.client.ClientObjectFactoryImpl;
import org.solent.com504.factoryandfacade.model.dto.Animal;
import org.solent.com504.factoryandfacade.model.service.FarmFacade;
import org.solent.com504.factoryandfacade.model.service.ServiceObjectFactory;

/**
 *
 * @author gallenc
 */
public class RestClientFarmFacadeTest {

    final static Logger LOG = LogManager.getLogger(RestClientFarmFacadeTest.class);

    ServiceObjectFactory serviceObjectFactory = null;
    FarmFacade farmFacade = null;

    List<String> supportedAnimalTypes = null;

    @Before
    public void loadFactory() {
        serviceObjectFactory = new ClientObjectFactoryImpl();
        farmFacade = serviceObjectFactory.getFarmFacade();
        assertNotNull(farmFacade);
    }

    @Test
    public void testGetAllAnimals() {
        LOG.debug("start of testGetAllAnimals()");
        String msg = "returned :";
        List<Animal> animals = farmFacade.getAllAnimals();
        for (Animal value : animals) {
            msg = msg + value + ",";
        }
        LOG.debug(msg);
        LOG.debug("end of testGetAllAnimals()");
    }

    @Test
    public void testAddAnimal() {
        LOG.debug("testAddAnimal()");
        String animalType = "Cat";
        String name = "randomName_" + new Date().getTime();
        Animal animal = farmFacade.addAnimal(animalType, name);
        String msg = "returned :" + animal;
        LOG.debug(msg);
        LOG.debug("end of testAddAnimal()");
    }

    @Test
    public void testGetAnimalsOfType() {
        LOG.debug("testGetAnimalsOfType()");
        List<String> supportedAnimalTypes = farmFacade.getSupportedAnimalTypes();
        
        for (String type : supportedAnimalTypes) {
            LOG.debug("type : " + type);
            String msg = "returned :";
            List<Animal> animals = farmFacade.getAnimalsOfType(type);
            for (Animal animal : animals) {
                msg = msg + animal.toString() + ",";
            }
            LOG.debug(msg);
        }
        LOG.debug("end of testGetAnimalsOfType()");
    }
    
    // Own implementation
    @Test
    public void testGetAnimal() {
        LOG.debug("testGetAnimal()");
        List<Animal> animals = farmFacade.getAllAnimals();
        
        for (Animal animal : animals) {
            LOG.debug("name : " + animal.getName());
            LOG.debug("returned :" + farmFacade.getAnimal(animal.getName()));
        }
        LOG.debug("end of testGetAnimal()");
    }

    // Own implementation
    @Test
    public void testRemoveAnimal() {
        LOG.debug("testRemoveAnimal()");

        farmFacade.addAnimal("Cat", "randomName_1");
        farmFacade.addAnimal("Dog", "randomName_2");
        farmFacade.addAnimal("Cow", "randomName_3");
        
        LOG.debug("inital animals : " + farmFacade.getAllAnimals());
        
        farmFacade.removeAnimal("randomName_1");
        farmFacade.removeAnimal("randomName_2");
        farmFacade.removeAnimal("randomName_3");
        
        LOG.debug("returned : " + farmFacade.getAllAnimals());
        
        LOG.debug("end of testGetAnimal()");
    }

    @Test
    public void testGetSupportedAnimalTypes() {
        LOG.debug("start of testSupportedAnimalTypes()");
        List<String> supportedAnimalTypes = farmFacade.getSupportedAnimalTypes();
        String msg = "returned :";
        for (String value : supportedAnimalTypes) {
            msg = msg + value + ",";
        }
        LOG.debug(msg);
        LOG.debug("end of testSupportedAnimalTypes()");
    }
}
