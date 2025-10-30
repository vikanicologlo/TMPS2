public class SeasonalMenuFactoryImpl implements SeasonalMenuFactory {
    @Override
    public Coffee createPumpkinSpiceLatte(Intensity intensity, MilkType milk) {
        return new PumpkinSpiceLatte(intensity, milk);
    }

    @Override
    public Coffee createRaf(Intensity intensity, SyrupType syrup) {
        return new Raf(intensity, syrup);
    }
}