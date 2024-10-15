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
        System.out.println("Введите кличку домашнего животного:\n");
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
        if (strIsNullOrEmpty(dateOfDeathStr)) {
            presenter.addAnimal(type, name, commands, dateOfBirth);
        } else {
            LocalDate dateOfDeath = LocalDate.parse(dateOfBirthStr, formatter);
            presenter.addAnimal(type, name, commands, dateOfBirth, dateOfDeath);
        }
    }


    public void getAnimalsList() {
        System.out.println("Введите тип домашнего животного: (CAT, DOG, HAMSTER)\n");
        String type = scanner.nextLine();
        presenter.getAimalListInfo(type);
    }

    public void removeAnimal() {
        System.out.println("Введите кличку домашнего животного:\n");
        String name = scanner.nextLine();
        boolean result = presenter.removeAnimal(name);
        if (result) {
            System.out.println("Успешно удалено\n");
        } else {
            System.out.println("Ошибка удаления\n");
        }
    }

    public void showCommands() {
        System.out.println("Введите кличку домашнего животного:\n");
        String name = scanner.nextLine();
        presenter.showCommands(name);
    }

    public void sortByBirthDate() {
        System.out.println("Введите тип домашнего животного: (CAT, DOG, HAMSTER)\n");
        String type = scanner.nextLine();
        presenter.sortByBirthDate(type);
    }

    public void endProgram() {
        work = false;
        System.out.println("До новых встреч!");
    }

    public boolean strIsNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }
}
