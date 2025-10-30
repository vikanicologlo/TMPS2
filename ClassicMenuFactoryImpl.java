public class ClassicMenuFactoryImpl implements ClassicMenuFactory {
    @Override
    public Coffee createCappuccino(Intensity intensity, MilkType milk) {
        return new Cappuccino(intensity, milk);
    }

    @Override
    public Coffee createSyrupCappuccino(Intensity intensity, MilkType milk, SyrupType syrup) {
        return new SyrupCappuccino(intensity, syrup, milk);
    }
}