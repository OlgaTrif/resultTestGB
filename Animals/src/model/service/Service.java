package model.service;

import model.animal.Animal;
import model.pet.cat.Cat;
import model.pet.dog.Dog;
import model.pet.hamster.Hamster;
import model.reader.AnimalReader;
import model.reader.AnimalReaderable;
import model.writer.AnimalWritable;
import model.writer.AnimalWriter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    List<Animal> animals= new ArrayList<>();
    private static final String filePath = "src/animals.txt";

    public Service() {
        try {
            List<Animal> animalsList = load();
            setAnimals(animalsList);
        } catch (Exception e) {
            animals = new ArrayList<>();
        }
    }

    public static Service service() {
        return new Service();
    }

    public void addAnimal(String type, String name, ArrayList<String> commands, LocalDate dateOfBirth){

    }

    public void addAnimal(String type, String name, ArrayList<String> commands,
                          LocalDate dateOfBirth, LocalDate dateOfDeath){

    }

    public String getAnimalListInfo() {
    }

    public void sortAnimalsByBirthDate() {
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

    public void setAnimals(List<Animal> animalsList) {
        animals = animalsList;
        save(animals);
    }

    private static void save(List<Animal> animalsList){
        AnimalWritable writer = new AnimalWriter();
        writer.write(animalsList, filePath);
    }

    private static List<Animal> load(){
        AnimalReaderable reader = new AnimalReader();
        try {
            return (List<Animal>) reader.read(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
