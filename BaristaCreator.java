public abstract class BaristaCreator {
    protected abstract Coffee createCoffee(DrinkType type, ConsoleUI ui);

    public Coffee takeOrder(DrinkType type, ConsoleUI ui) {
        return createCoffee(type, ui);
    }
}