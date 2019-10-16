package org.solent.com504.factoryandfacade.impl.service;

import java.util.ArrayList;
import java.util.List;
import org.solent.com504.factoryandfacade.model.dao.AnimalDao;
import org.solent.com504.factoryandfacade.model.dao.AnimalTypeDao;
import org.solent.com504.factoryandfacade.model.dto.Animal;
import org.solent.com504.factoryandfacade.model.service.FarmFacade;

public class FarmFacadeImpl implements FarmFacade {

    private AnimalDao animalDao = null;
    
    private AnimalTypeDao animalTypeDao = null;

   // setters for DAOs
    public void setAnimalDao(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    public void setAnimalTypeDao(AnimalTypeDao animalTypeDao) {
        this.animalTypeDao = animalTypeDao;
    }
    
    // Farm facade methods
    @Override
    public List<Animal> getAllAnimals() {
        return animalDao.retrieveAll();
    }

    @Override
    public Animal addAnimal(String animalType, String name) {
        Animal animal = animalDao.create(animalTypeDao.getAnimalType(animalType));
        animal.setName(name);
        animalDao.updateOrSave(animal);
        return animal;
    }

    @Override
    public List<Animal> getAnimalsOfType(String animalType) {
        Animal template = animalDao.create(animalTypeDao.getAnimalType(animalType));
        return animalDao.retrieve(template);
    }

    @Override
    public Animal getAnimal(String name) {
        Animal template = animalDao.create(null);
        template.setName(name);
        return animalDao.retrieve(template).get(0);
    }

    @Override
    public boolean removeAnimal(String name) {
        Animal animalToDelete = getAnimal(name);
        if (animalToDelete != null) {
            return animalDao.delete(animalToDelete.getId());
        }
        return false;
    }

    @Override
    public List<String> getSupportedAnimalTypes() {
        List<String> stringList = new ArrayList<>();
        animalTypeDao.getSupportedAnimalTypes().forEach((type) -> {
            stringList.add(type.toString());
        });              
        return stringList;
    }
}
