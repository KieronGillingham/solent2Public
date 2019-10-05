package org.solent.com504.factoryandfacade.UML_gen_model2;

import java.util.List;

public interface FarmFacade {

    public List<Animal> getAllAnimals();

    public String addDog(String name);

    public String addCat(String name);

    public String addCow(String name);

    public String addDuck(String name);
}
