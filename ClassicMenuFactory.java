public interface ClassicMenuFactory {
    Coffee createCappuccino(Intensity intensity, MilkType milk);
    Coffee createSyrupCappuccino(Intensity intensity, MilkType milk, SyrupType syrup);
}