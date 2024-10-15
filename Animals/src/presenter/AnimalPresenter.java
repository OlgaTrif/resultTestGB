package presenter;

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
        try {
            service.addAnimal(type, name, commands, dateOfBirth);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addAnimal(String type, String name, ArrayList<String> commands,
                          LocalDate dateOfBirth, LocalDate dateOfDeath) {
        try {
            service.addAnimal(type, name, commands, dateOfBirth, dateOfDeath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void getAimalListInfo(String type) {
        view.printAnswer(service.getAnimalListInfo(type));
    }

    public void showCommands(String name) {
        view.printAnswer(service.showCommands(name));
    }

    public void sortByBirthDate(String type) {
        view.printAnswer(service.sortByBirthDate(type));
    }

    public void removeAnimal(String name){
        service.removeAnimal(name);
    }

    public String showCounter() {
        return service.showCount().toString();
    }

    public void addNewCommand(String name, String newCommand) {
        service.addNewCommand(name, newCommand);
    }
}
