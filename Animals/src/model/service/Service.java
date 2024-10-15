package model.service;

import model.animal.Animal;
import model.animal.AnimalCounter;
import model.animal.AnimalList;
import model.animal.comparators.BirthDayComparator;
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
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Collections.*;

public class Service {
    private static final String ANIMAL_NOT_FOUND_EXCEPTION = "Животное не найдено. Проверьте корректность клички";
    private static final String COMMA = ", ";
    private AnimalList<Object> animals = new AnimalList<>();
    private static final String filePath = "src/Animals.txt";

    public Service() {
        try {
            AnimalList<Object> animalsList = load();
            setAnimals(animalsList);
        } catch (Exception e) {
            animals = new AnimalList<>();
        }
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

    public String getAnimalListInfo(String typeStr) {
        return getAnimalListByType(typeStr).toString();
    }

    public String showCommands(String name) {
        Animal animal = findAnimalByName(name);
        if (animal == null) {
            return ANIMAL_NOT_FOUND_EXCEPTION;
        }
        List<String> commands;
        commands = animal.getCommandList();
        StringBuilder commandsStr = new StringBuilder();
        for (String c :commands) {
            commandsStr.append(c).append(COMMA);
        }
        return commandsStr.toString();
    }

    public String sortByBirthDate(String typeStr) {
        List<Object> animalsList = getAnimalListByType(typeStr);
        Collections.sort(animalsList, new BirthDayComparator());
        return animalsList.toString();
    }

    public boolean removeAnimal(String name) {
        return animals.removeAnimal(findAnimalByName(name));
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

    public Animal findAnimalByName(String name) {
        Animal animal;
        animal = animals.findCat(name);
        if (animal == null){
            animal = animals.findDog(name);
            if (animal == null) {
                animal = animals.findHamster(name);
            }
        }
        return animal;
    }

    private List<Object> getAnimalListByType(String typeStr){
        List<Object> animalsList = new ArrayList<>();
        AnimalTypes type = AnimalTypes.valueOf(typeStr);
        switch (type) {
            case CAT -> animalsList = animals.getCats();
            case DOG -> animalsList = animals.getDogs();
            case HAMSTER -> animalsList = animals.getHamsters();
        }
        return animalsList;
    }
}
