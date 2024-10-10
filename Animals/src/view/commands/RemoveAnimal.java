package view.commands;

import view.ConsoleUI;

public class RemoveAnimal extends Command{

    public RemoveAnimal(ConsoleUI consoleUI) {
        super("Удалить члена", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().removeAnimal();
    }
}
