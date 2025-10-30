public class Americano extends Coffee {
    private final int mlOfWater;

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity, "Americano");
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void brew() {
        System.out.println("\nMaking " + getName() + "...");
        printCoffeeDetails();
        System.out.println("Adding " + mlOfWater + " ml of water");
    }
}