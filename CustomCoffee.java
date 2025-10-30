public class CustomCoffee extends Coffee {
    private final boolean milk;
    private final MilkType milkType;   // null, если milk=false
    private final SyrupType syrup;     // null, если без сиропа
    private final boolean pumpkinSpice;

    private CustomCoffee(Intensity intensity, boolean milk, MilkType milkType, SyrupType syrup, boolean pumpkinSpice) {
        super(intensity, "Custom Coffee");
        this.milk = milk;
        this.milkType = milk ? milkType : null;
        this.syrup = syrup;
        this.pumpkinSpice = pumpkinSpice;
    }

    @Override
    public void brew() {
        System.out.println("\nMaking " + getName() + "...");
        printCoffeeDetails();

        if (milk) {
            System.out.println("Adding " + milkType + " milk");
        } else {
            System.out.println("Without milk");
        }

        if (syrup != null) {
            System.out.println("Adding " + syrup + " syrup");
        } else {
            System.out.println("Without syrup");
        }

        if (pumpkinSpice) {
            System.out.println("Adding pumpkin spice");
        } else {
            System.out.println("Without pumpkin spice");
        }
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Intensity intensity = Intensity.MEDIUM;
        private boolean milk = false;
        private MilkType milkType = MilkType.DAIRY;
        private SyrupType syrup = null;
        private boolean pumpkinSpice = false;

        public Builder intensity(Intensity i) { if (i != null) this.intensity = i; return this; }
        public Builder withMilk(boolean v) { this.milk = v; return this; }
        public Builder milkType(MilkType t) { if (t != null) this.milkType = t; return this; }
        public Builder syrup(SyrupType t) { this.syrup = t; return this; }
        public Builder pumpkinSpice(boolean v) { this.pumpkinSpice = v; return this; }

        public CustomCoffee build() {
            return new CustomCoffee(intensity, milk, milk ? milkType : null, syrup, pumpkinSpice);
        }
    }
}