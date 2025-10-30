public class Raf extends Coffee {
    private final SyrupType syrup;

    public Raf(Intensity intensity, SyrupType syrup) {
        super(intensity, "Raf");
        this.syrup = syrup;
    }

    @Override
    public void brew() {
        System.out.println("\nMaking " + getName() + "...");
        printCoffeeDetails();
        System.out.println("Adding CREAM and " + syrup + " syrup");
    }
}