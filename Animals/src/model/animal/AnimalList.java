package model.animal;

import model.pet.cat.Cat;
import model.pet.dog.Dog;
import model.pet.hamster.Hamster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AnimalList <Animal> implements Serializable {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal){
        animals.remove(animal);
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public List<Animal> getCats(){
        return animals.stream().filter(x -> x instanceof Cat).toList();
    }

    public List<Animal> getDogs(){
        return animals.stream().filter(x -> x instanceof Dog).toList();
    }

    public List<Animal> getHamsters(){
        return animals.stream().filter(x -> x instanceof Hamster).toList();
    }

    public Cat findCat(String name){
        List<Cat> cats = (List<Cat>) this.getCats();
        Cat cat;

        try {
            cat = cats.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            cat = null;
        }
        return cat;
    }

    public Dog findDog(String name){
        List<Dog> dogs = (List<Dog>) this.getDogs();
        Dog dog;

        try {
            dog = dogs.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            dog = null;
        }
        return dog;
    }

    public Hamster findHamster(String name){
        List<Hamster> hamsters = (List<Hamster>) this.getHamsters();
        Hamster hamster;

        try {
            hamster = hamsters.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            hamster = null;
        }
        return hamster;
    }

    public Integer getCount() {
        return getAnimals().size();
    }
}
