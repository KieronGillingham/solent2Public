package org.solent.com504.factoryandfacade.impl;

import org.solent.com504.factoryandfacade.model.Dog;

public class AltDogImpl extends AbstractAnimal implements Dog {

    @Override
    public String getSound() {
        return "Yelp!";
    }

    @Override
    public String getAnimalType() {
        return Dog.ANIMAL_TYPE;
    }

}
