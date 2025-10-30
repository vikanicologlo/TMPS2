public class ClassicBarista extends BaristaCreator {
    private final ClassicMenuFactory menu = new ClassicMenuFactoryImpl();

    @Override
    protected Coffee createCoffee(DrinkType type, ConsoleUI ui) {
        switch (type) {
            case AMERICANO:
                return new Americano(ui.askIntensity(), ui.askWaterAmount());
            case CAPPUCCINO:
                return menu.createCappuccino(ui.askIntensity(), ui.askMilkType());
            case SYRUP_CAPPUCCINO:
                return menu.createSyrupCappuccino(ui.askIntensity(), ui.askMilkType(), ui.askSyrupTypeRequired());
            default:
                throw new IllegalArgumentException("Not in classic menu: " + type);
        }
    }
}