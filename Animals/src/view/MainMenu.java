package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddAnimal(consoleUI));
        commands.add(new AddCommand(consoleUI));
        commands.add(new GetAnimalsList(consoleUI));
        commands.add(new ShowCommands(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new RemoveAnimal(consoleUI));
        commands.add(new EndProgram(consoleUI));
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Выберите действие:\n");
        for(int i = 0; i < commands.size(); i++) {
            sb.append(i + 1);
            sb.append("- ");
            sb.append(commands.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size(){
        return commands.size();
    }
}
