package view;

import presenter.AnimalPresenter;

import java.util.Scanner;

public class ConsoleUI implements AnimalView{

    private final Scanner scanner;
    private final AnimalPresenter presenter;
    private boolean work;
    private final MainMenu mainMenu;

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
    }

    public void addCommand() {
    }

    public void getAnimalsList() {
    }

    public void removeAnimal() {
    }

    public void sortByAge() {
    }

    public void sortByName() {
    }
}
