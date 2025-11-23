public class ConsoleUI {
    private final InputProvider input;

    public ConsoleUI(InputProvider input) {
        this.input = input;
    }

    public boolean askYesNo(String prompt) {
        while (true) {
            String s = input.readString(prompt + " (y/n): ");
            if (s == null) continue;
            s = s.trim().toLowerCase();
            if (s.startsWith("y")) return true;
            if (s.startsWith("n")) return false;
            System.out.println("❌ Invalid choice. Please enter 'y' or 'n'.\n");
        }
    }

    public int askMenuType() {
        while (true) {
            System.out.println("\nChoose a menu:");
            System.out.println("1) Classic");
            System.out.println("2) Seasonal");
            System.out.println("3) Build a custom drink");
            int n = input.readInt("Your choice: ");
            if (n >= 1 && n <= 3) return n;
            System.out.println("❌ Invalid choice. Please try again.");
        }
    }

    public int askMainMenu() {
        while (true) {
            System.out.println("\nWhat would you like?");
            System.out.println("1) Classic coffee menu");
            System.out.println("2) Seasonal coffee menu");
            System.out.println("3) Build a custom drink");
            System.out.println("4) Get a tarot reading 🔮");
            int n = input.readInt("Your choice: ");
            if (n >= 1 && n <= 4) return n;
            System.out.println("❌ Invalid choice. Please try again.");
        }
    }

    public Intensity askIntensity() {
        while (true) {
            System.out.println("Choose intensity: 1) LIGHT  2) MEDIUM  3) STRONG");
            int n = input.readInt("Your choice: ");
            switch (n) {
                case 1: return Intensity.LIGHT;
                case 2: return Intensity.MEDIUM;
                case 3: return Intensity.STRONG;
            }
            System.out.println("❌ Invalid choice. Please try again.\n");
        }
    }

    public int askWaterAmount() {
        while (true) {
            int ml = input.readInt("Enter ml of water:  ");
            if (ml > 0) return ml;
            System.out.println("❌ Please enter valid number\n");
        }
    }

    public MilkType askMilkType() {
        while (true) {
            System.out.println("Milk type: 1) DAIRY  2) COCONUT");
            int n = input.readInt("Your choice: ");
            switch (n) {
                case 1: return MilkType.DAIRY;
                case 2: return MilkType.COCONUT;
            }
            System.out.println("❌ Invalid choice. Please try again.\n");
        }
    }

    public SyrupType askSyrupTypeRequired() {
        while (true) {
            System.out.println("Syrup: 1) VANILLA  2) CARAMEL  3) HAZELNUT");
            int n = input.readInt("Your choice: ");
            switch (n) {
                case 1: return SyrupType.VANILLA;
                case 2: return SyrupType.CARAMEL;
                case 3: return SyrupType.HAZELNUT;
            }
            System.out.println("❌ Invalid choice. Please try again.\n");
        }
    }

    public SyrupType askSyrupTypeOrNull() {
        boolean add = askYesNo("Add syrup?");
        if (!add) return null;
        return askSyrupTypeRequired();
    }


    public DrinkType askClassicDrinkType() {
        while (true) {
            System.out.println("\nClassic menu:");
            System.out.println("1) Americano");
            System.out.println("2) Cappuccino");
            System.out.println("3) Syrup Cappuccino");
            int n = input.readInt("Your choice: ");
            switch (n) {
                case 1: return DrinkType.AMERICANO;
                case 2: return DrinkType.CAPPUCCINO;
                case 3: return DrinkType.SYRUP_CAPPUCCINO;
            }
            System.out.println("❌ Invalid choice. Please try again.");
        }
    }

    // ===== Seasonal submenu (no Custom here) =====
    public DrinkType askSeasonalDrinkType() {
        while (true) {
            System.out.println("\nSeasonal menu:");
            System.out.println("1) Pumpkin Spice Latte");
            System.out.println("2) Raf");
            int n = input.readInt("Your choice: ");
            switch (n) {
                case 1: return DrinkType.PUMPKIN_SPICE_LATTE;
                case 2: return DrinkType.RAF;

            }
            System.out.println("❌ Invalid choice. Please try again.");
        }
    }

    // ===== Tarot Reading Methods =====
    public String askTarotQuestion() {
        System.out.println("\n🔮 Welcome to the Tarot Reading 🔮");
        String question = input.readString("Please enter your question: ");
        if (question == null || question.trim().isEmpty()) {
            return "What does the future hold for me?";
        }
        return question.trim();
    }

    public int askNumberOfCards() {
        while (true) {
            System.out.println("\nHow many cards would you like to draw?");
            System.out.println("1) One card (quick insight)");
            System.out.println("2) Three cards (past, present, future)");
            System.out.println("3) Five cards (detailed reading)");
            int n = input.readInt("Your choice: ");
            switch (n) {
                case 1: return 1;
                case 2: return 3;
                case 3: return 5;
            }
            System.out.println("❌ Invalid choice. Please try again.\n");
        }
    }
}