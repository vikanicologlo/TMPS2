public class PumpkinSpiceLatte extends Coffee {
    private final MilkType milk;

    public PumpkinSpiceLatte(Intensity intensity, MilkType milk) {
        super(intensity, "Pumpkin Spice Latte");
        this.milk = milk;
    }

    @Override
    public void brew() {
        System.out.println("\nMaking " + getName() + "...");
        printCoffeeDetails();
        System.out.println("Adding " + milk + " milk and pumpkin spice");
    }
}