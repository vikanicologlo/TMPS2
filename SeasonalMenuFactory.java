public interface SeasonalMenuFactory {
    Coffee createPumpkinSpiceLatte(Intensity intensity, MilkType milk);
    Coffee createRaf(Intensity intensity, SyrupType syrup);
}