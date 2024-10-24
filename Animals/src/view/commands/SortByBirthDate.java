package view.commands;

import view.ConsoleUI;

public class SortByBirthDate extends Command{

    public SortByBirthDate(ConsoleUI consoleUI) {
        super("Сортировка по дате рождения", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByBirthDate();
    }
}
