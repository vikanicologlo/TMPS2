public class SyrupCappuccino extends Coffee {
    private final SyrupType syrup;
    private final MilkType milk;

    public SyrupCappuccino(Intensity intensity, SyrupType syrup, MilkType milk) {
        super(intensity, "Syrup Cappuccino");
        this.syrup = syrup;
        this.milk = milk;
    }

    @Override
    public void brew() {
        System.out.println("\nMaking " + getName() + "...");
        printCoffeeDetails();
        System.out.println("Adding " + milk + " milk");
        System.out.println("Adding " + syrup + " syrup");
    }
}