public abstract class Coffee {
    private final Intensity intensity;
    private final String name;

    protected Coffee(Intensity intensity, String name) {
        this.intensity = intensity;
        this.name = name;
    }

    public Intensity getIntensity() { return intensity; }
    public String getName() { return name; }

    protected void printCoffeeDetails() {
        System.out.println("Intensity: " + intensity);
    }

    public abstract void brew();
}