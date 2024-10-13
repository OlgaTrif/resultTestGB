package view.commands;

import view.ConsoleUI;

public class ShowCommands extends Command{

    public ShowCommands(ConsoleUI consoleUI) {
        super("Показать команды животного", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().showCommands();
    }
}
