package view;

import presenter.AnimalPresenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsoleUI implements AnimalView{

    private final Scanner scanner;
    private final AnimalPresenter presenter;
    private boolean work;
    private final MainMenu mainMenu;
    private static final String SPACE = " ";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new AnimalPresenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        while (work) {
            System.out.println("Добро пожаловать!\n");
            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            if (choiceStr.isEmpty()) {
                System.out.println("Ошибка: Введена пустая команда");
                break;
            }
            if (choiceStr.length() > 1) {
                System.out.println("Ошибка: Введен недопустимый символ");
                break;
            }
            int choice = Integer.parseInt(choiceStr);
            if (mainMenu.size() < choice) {
                System.out.println("Ошибка: Проверьте номер команды");
                break;
            }
            mainMenu.execute(choice);
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void addAnimal() {
        System.out.println("Введите тип домашнего животного: (CAT, DOG, HAMSTER)\n");
        String type = scanner.nextLine();
        System.out.println("Введите кличку: \n");
        String name = scanner.nextLine();
        System.out.println("Введите команды через пробел: \n");
        String commandsStr = scanner.nextLine();
        ArrayList<String> commands = new ArrayList<>(Arrays.asList(commandsStr.split(SPACE)));
        System.out.println("Введите дату рождения (ДД.ММ.ГГГГ): \n");
        String dateOfBirthStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
        System.out.println("Введите дату смерти (ДД.ММ.ГГГГ). Если её нет, то нажмите Enter: \n");
        String dateOfDeathStr = scanner.nextLine();
        if (dateOfDeathStr.isEmpty()) {
            presenter.addAnimal(type, name, commands, dateOfBirth);
        } else {
            LocalDate dateOfDeath = LocalDate.parse(dateOfBirthStr, formatter);
            presenter.addAnimal(type, name, commands, dateOfBirth, dateOfDeath);
        }
    }

    public void addCommand() {
    }

    public void getAnimalsList() {
        presenter.getAimalListInfo();
    }

    public void removeAnimal() {
    }

    public void showCommands() {
    }

    public void sortByName() {
    }
}
