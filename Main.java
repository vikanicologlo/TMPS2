import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI(new ConsoleInput());

        System.out.println("Welcome to our coffee shop! ☕️");

        List<Coffee> orders = new ArrayList<>();
        boolean more = true;

        while (more) {
            int menuChoice = ui.askMenuType();
            BaristaCreator barista;
            DrinkType type;

            switch (menuChoice) {
                case 1: // классическое меню
                    barista = new ClassicBarista();
                    type = ui.askClassicDrinkType();
                    break;
                case 2: // сезонное меню
                    barista = new SeasonalBarista();
                    type = ui.askSeasonalDrinkType();
                    break;
                case 3: // кастом
                    barista = new CustomBarista();
                    type = DrinkType.CUSTOM;
                    break;
                default:
                    throw new IllegalArgumentException("Wrong choice");
            }

            orders.add(barista.takeOrder(type, ui));
            more = ui.askYesNo("Would you like something else?");
        }

        System.out.println("\nPrepare your drinks:");
        for (Coffee c : orders) c.brew();

        System.out.println("\nThanks for visiting us! 😊");
    }
}