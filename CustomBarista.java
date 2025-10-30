public class CustomBarista extends BaristaCreator {
    @Override
    protected Coffee createCoffee(DrinkType type, ConsoleUI ui) {
        if (type != DrinkType.CUSTOM) {
            throw new IllegalArgumentException("CustomBarista makes only CUSTOM");
        }

        Intensity intensity = ui.askIntensity();

        boolean addMilk = ui.askYesNo("Milk?");
        MilkType milkType = addMilk ? ui.askMilkType() : null;

        SyrupType syrup = ui.askSyrupTypeOrNull();        // null, если «нет»
        boolean addPumpkinSpice = ui.askYesNo("Pumpkin spice?");

        return CustomCoffee.builder()
                .intensity(intensity)
                .withMilk(addMilk)
                .milkType(milkType)        // игнорируется билдером, если addMilk=false
                .syrup(syrup)              // может быть null
                .pumpkinSpice(addPumpkinSpice)
                .build();
    }
}