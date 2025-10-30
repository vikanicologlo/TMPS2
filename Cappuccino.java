public class Cappuccino extends Coffee {
    private final MilkType milk;

    public Cappuccino(Intensity intensity, MilkType milk) {
        super(intensity, "Cappuccino");
        this.milk = milk;
    }

    @Override
    public void brew() {
        System.out.println("\nMaking " + getName() + "...");
        printCoffeeDetails();
        System.out.println("Adding " + milk + " milk");
    }
}