import view.AnimalView;
import view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        AnimalView view = new ConsoleUI();
        view.start();
    }
}