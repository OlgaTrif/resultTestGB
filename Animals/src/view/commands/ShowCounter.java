package view.commands;

import view.ConsoleUI;

public class ShowCounter extends Command{

    public ShowCounter(ConsoleUI consoleUI) {
        super("Показать количество животных", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().showCounter();
    }
}
