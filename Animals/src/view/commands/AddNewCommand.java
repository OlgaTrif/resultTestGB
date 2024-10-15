package view.commands;

import view.ConsoleUI;

public class AddNewCommand extends Command{

    public AddNewCommand(ConsoleUI consoleUI) {
        super("Добавить новую команду", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addNewCommand();
    }
}
