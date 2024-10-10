package view.commands;

import view.ConsoleUI;

public class AddAnimal extends Command{

    public AddAnimal(ConsoleUI consoleUI) {
        super("Добавить члена", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addAnimal();
    }
}
