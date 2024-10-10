package model.service;

import model.animal.Animal;
import model.pack.camel.Camel;
import model.pack.donkey.Donkey;
import model.pack.horse.Horse;
import model.pet.cat.Cat;
import model.pet.dog.Dog;
import model.pet.hamster.Hamster;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Service {
    List<Animal> animals= new ArrayList<>();
    private static final String filePath = "src/animals.txt";

    public Service() {
    }

    public static Service service() {
        return new Service();
    }

    public void addAnimal(String type, String name, ArrayList<String> commands, LocalDate dateOfBirth){

    }

    public void addAnimal(String type, String name, ArrayList<String> commands,
                          LocalDate dateOfBirth, LocalDate dateOfDeath){

    }

    public void addCat(String name, ArrayList<String> commands, LocalDate dateOfBirth){
        Cat cat = new Cat(name, commands, dateOfBirth);
    }

    public void addDog(String name, ArrayList<String> commands, LocalDate dateOfBirth){
        Dog dog = new Dog(name, commands, dateOfBirth);
    }

    public void addHamster(String name, ArrayList<String> commands, LocalDate dateOfBirth){
        Hamster hamster = new Hamster(name, commands, dateOfBirth);
    }

    public void addCamel(String name, ArrayList<String> commands, LocalDate dateOfBirth){
        Camel camel = new Camel(name, commands, dateOfBirth);
    }

    public void addDonkey(String name, ArrayList<String> commands, LocalDate dateOfBirth){
        Donkey donkey = new Donkey(name, commands, dateOfBirth);
    }

    public void addHose(String name, ArrayList<String> commands, LocalDate dateOfBirth){
        Horse horse = new Horse(name, commands, dateOfBirth);
    }

    public String getAnimalListInfo() {
    }

    public void sortAnimalsByBirthDate() {
    }

    public void sortAnimalsByName() {
    }

    public Animal getAnimalById(Integer id) {
    }

    public void addCommand(String command) {
    }

    public void removeCommand(Integer animalId) {
    }
}
