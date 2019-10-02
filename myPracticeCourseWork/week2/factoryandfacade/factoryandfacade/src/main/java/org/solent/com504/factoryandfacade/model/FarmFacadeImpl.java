/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 4gillk91
 */
public class FarmFacadeImpl implements FarmFacade{

    private List<Animal> allAnimals = new ArrayList<>();
    
    @Override
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(allAnimals);
    }

    @Override
    public void addDog(String name){
        Dog d = (Dog) AnimalObjectFactory.createDog();
        d.setName(name);
        allAnimals.add(d);
    }

    @Override
    public void addCat(String name) {
        Cat c = (Cat) AnimalObjectFactory.createCat();
        c.setName(name);
        allAnimals.add(c);
    }

    @Override
    public void addCow(String name) {
        Cow c = (Cow) AnimalObjectFactory.createCow();
        c.setName(name);
        allAnimals.add(c);
    }
}