package presenter;

import model.animal.Animal;
import model.service.Service;
import view.AnimalView;

import java.time.LocalDate;
import java.util.ArrayList;

public class AnimalPresenter {
    private final AnimalView view;
    private final Service service;

    public AnimalPresenter(AnimalView view) {
        this.view = view;
        service = new Service();
    }

    public void addAnimal(String type, String name, ArrayList<String> commands, LocalDate dateOfBirth) {
        service.addAnimal(type, name, commands, dateOfBirth);
        getAimalListInfo();
    }

    public void addAnimal(String type, String name, ArrayList<String> commands,
                          LocalDate dateOfBirth, LocalDate dateOfDeath) {
        service.addAnimal(type, name, commands, dateOfBirth, dateOfDeath);
        getAimalListInfo();
    }

    public void getAimalListInfo() {
        view.printAnswer(service.getAnimalListInfo());
    }

    public void showCommands() {
        service.showCommands();
        getAimalListInfo();
    }

    public void sortByName() {
        service.sortAnimalsByName();
        getAimalListInfo();
    }

    public Animal getMemberById(Integer id){
        return service.getAnimalById(id);
    }

    public void addCommand(String command) {
        service.addCommand(command);
    }

    public void removeCommand(Integer animalId){
        service.removeCommand(animalId);
    }
}
