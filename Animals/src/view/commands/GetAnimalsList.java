package view.commands;

import view.ConsoleUI;

public class GetAnimalsList extends Command{

        public GetAnimalsList(ConsoleUI consoleUI) {
            super("Вывести список всех членов", consoleUI);
        }

        @Override
        public void execute(){
            getConsoleUI().getAnimalsList();
        }
}
