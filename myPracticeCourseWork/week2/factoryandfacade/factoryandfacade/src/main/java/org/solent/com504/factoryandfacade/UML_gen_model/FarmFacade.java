package org.solent.com504.factoryandfacade.UML_gen_model;

import java.util.List;

public interface FarmFacade {

    public List<Animal> getAllAnimals();

    public void addDog(String name);

    public void addCat(String name);

    public void addCow(String name);
}
