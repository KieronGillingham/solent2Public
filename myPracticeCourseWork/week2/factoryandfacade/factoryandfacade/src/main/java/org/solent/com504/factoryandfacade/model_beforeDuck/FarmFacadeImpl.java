/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.model_beforeDuck;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 4gillk91
 */
public class FarmFacadeImpl implements FarmFacade {

    private List<Animal> allAnimals = new ArrayList<>();
    
    @Override
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(allAnimals);
    }

    @Override
    public void addDog(String name) {
        Dog dog = (Dog) AnimalObjectFactory.createDog();
        dog.setName(name);
        allAnimals.add(dog);
    }

    @Override
    public void addCat(String name) {
        Cat cat = (Cat) AnimalObjectFactory.createCat();
        cat.setName(name);
        allAnimals.add(cat);
    }

    @Override
    public void addCow(String name) {
        Cow cow = (Cow) AnimalObjectFactory.createCow();
        cow.setName(name);
        allAnimals.add(cow);
    }
}