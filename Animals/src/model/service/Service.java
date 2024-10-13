package model.service;

import model.animal.Animal;
import model.animal.AnimalCounter;
import model.animal.AnimalList;
import model.pet.AnimalTypes;
import model.pet.cat.Cat;
import model.pet.dog.Dog;
import model.pet.hamster.Hamster;
import model.reader.AnimalReader;
import model.reader.AnimalReaderable;
import model.writer.AnimalWritable;
import model.writer.AnimalWriter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static model.pet.AnimalTypes.*;

public class Service {
    private AnimalList<Object> animals = new AnimalList<>();
    private static final String filePath = "src/animals.txt";

    public Service() {
        try {
            AnimalList<Object> animalsList = load();
            setAnimals(animalsList);
        } catch (Exception e) {
            animals = new AnimalList<>();
        }
    }

    public static Service service() {
        return new Service();
    }

    public void addAnimal(String type, String name, ArrayList<String> commands, LocalDate dateOfBirth) throws Exception {
        try(AnimalCounter counter = new AnimalCounter()){
            counter.add();
        }
        AnimalTypes animalType = AnimalTypes.valueOf(type);
        switch (animalType) {
            case CAT -> animals.addAnimal(new Cat(name, commands, dateOfBirth));
            case DOG -> animals.addAnimal(new Dog(name, commands, dateOfBirth));
            case HAMSTER -> animals.addAnimal(new Hamster(name, commands, dateOfBirth));
        }
    }

    public void addAnimal(String type, String name, ArrayList<String> commands,
                          LocalDate dateOfBirth, LocalDate dateOfDeath) throws Exception {
        try(AnimalCounter counter = new AnimalCounter()){
            counter.add();
        }
        AnimalTypes animalType = AnimalTypes.valueOf(type);
        switch (animalType) {
            case CAT -> animals.addAnimal(new Cat(name, commands, dateOfBirth, dateOfDeath));
            case DOG -> animals.addAnimal(new Dog(name, commands, dateOfBirth, dateOfDeath));
            case HAMSTER -> animals.addAnimal(new Hamster(name, commands, dateOfBirth, dateOfDeath));
        }
    }

    public String getAnimalListInfo() {
    }

    public void showCommands() {
    }

    public void sortAnimalsByName() {
    }

    public Animal getAnimalById(Integer id) {
        return null;
    }

    public void addCommand(String command) {
    }

    public void removeCommand(Integer animalId) {
    }

    public void setAnimals(AnimalList<Object> animalsList) {
        animals = animalsList;
        save(animals);
    }

    private static void save(AnimalList<Object> animalsList){
        AnimalWritable writer = new AnimalWriter();
        writer.write(animalsList, filePath);
    }

    private static AnimalList<Object> load(){
        AnimalReaderable reader = new AnimalReader();
        try {
            return (AnimalList<Object>) reader.read(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void showCountAnimals() throws Exception{
        try(AnimalCounter counter = new AnimalCounter()){
            Logger.getAnonymousLogger().info(counter.getCount().toString());
        }
    }
}
