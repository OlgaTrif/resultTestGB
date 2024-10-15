package model.service;

import model.animal.Animal;
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
import java.util.Comparator;
import java.util.List;

public class Service {
    private static final String ANIMAL_NOT_FOUND_EXCEPTION = "Животное не найдено. Проверьте корректность клички";
    private static final String COMMA = ", ";
    private AnimalList<Animal> animals = new AnimalList<>();
    private static final String filePath = "src/Animals.txt";

    public Service() {
        try {
            AnimalList<Animal> animalsList = load();
            setAnimals(animalsList);
        } catch (Exception e) {
            animals = new AnimalList<>();
        }
    }

    public void addAnimal(String type, String name, ArrayList<String> commands, LocalDate dateOfBirth) throws Exception {
        AnimalTypes animalType = AnimalTypes.valueOf(type);
        switch (animalType) {
            case CAT -> animals.addAnimal(new Cat(name, commands, dateOfBirth));
            case DOG -> animals.addAnimal(new Dog(name, commands, dateOfBirth));
            case HAMSTER -> animals.addAnimal(new Hamster(name, commands, dateOfBirth));
        }
        save(animals);
    }

    public void addAnimal(String type, String name, ArrayList<String> commands,
                          LocalDate dateOfBirth, LocalDate dateOfDeath) throws Exception {
        AnimalTypes animalType = AnimalTypes.valueOf(type);
        switch (animalType) {
            case CAT -> animals.addAnimal(new Cat(name, commands, dateOfBirth, dateOfDeath));
            case DOG -> animals.addAnimal(new Dog(name, commands, dateOfBirth, dateOfDeath));
            case HAMSTER -> animals.addAnimal(new Hamster(name, commands, dateOfBirth, dateOfDeath));
        }
        save(animals);
    }

    public String getAnimalListInfo(String typeStr) {
        List<Animal> animalList = getAnimalListByType(typeStr);
        StringBuilder sb = new StringBuilder();
        for (Animal an : animalList) {
            if (!sb.isEmpty()) {
                sb.append(";\n");
            }
            sb.append(an.getInfo());
        }
        return sb.toString();
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
        List<Animal> animalsList = getAnimalListByType(typeStr);
        Collections.sort(animalsList, new BirthDayComparator<>());
        Collections.sort(animalsList, Comparator.comparing(Animal::getDateOfBirth));
        return getAnimalListInfo(typeStr);
    }

    public void removeAnimal(String name) {
        animals.removeAnimal(findAnimalByName(name));
        save(animals);
    }

    public void setAnimals(AnimalList<Animal> animalsList) {
        animals = animalsList;
        save(animals);
    }

    private static void save(AnimalList<Animal> animalsList){
        AnimalWritable writer = new AnimalWriter();
        writer.write(animalsList, filePath);
    }

    private static AnimalList<Animal> load(){
        AnimalReaderable reader = new AnimalReader();
        try {
            return (AnimalList<Animal>) reader.read(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
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

    private List<Animal> getAnimalListByType(String typeStr){
        List<Animal> animalsList = new ArrayList<>();
        AnimalTypes type = AnimalTypes.valueOf(typeStr);
        switch (type) {
            case CAT -> animalsList = animals.getCats();
            case DOG -> animalsList = animals.getDogs();
            case HAMSTER -> animalsList = animals.getHamsters();
        }
        return animalsList;
    }

    public Integer showCount() {
        return animals.getCount();
    }

    public void addNewCommand(String name, String newCommand) {
        Animal animal = findAnimalByName(name);
        if (animal == null) {
            return;
        }
        animal.addCommand(newCommand);
        save(animals);
    }
}
