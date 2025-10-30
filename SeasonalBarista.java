public class SeasonalBarista extends BaristaCreator {
    private final SeasonalMenuFactory menu = new SeasonalMenuFactoryImpl();

    @Override
    protected Coffee createCoffee(DrinkType type, ConsoleUI ui) {
        switch (type) {
            case PUMPKIN_SPICE_LATTE:
                return menu.createPumpkinSpiceLatte(ui.askIntensity(), ui.askMilkType());
            case RAF:
                return menu.createRaf(ui.askIntensity(), ui.askSyrupTypeRequired());
            default:
                throw new IllegalArgumentException("Not in seasonal menu: " + type);
        }
    }
}