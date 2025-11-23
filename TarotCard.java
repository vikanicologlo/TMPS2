public class TarotCard {
    private final String name;
    private final String meaning;
    private final String reversedMeaning;
    private final boolean reversed;

    public TarotCard(String name, String meaning, String reversedMeaning, boolean reversed) {
        this.name = name;
        this.meaning = meaning;
        this.reversedMeaning = reversedMeaning;
        this.reversed = reversed;
    }

    public String getName() {
        return name;
    }

    public String getMeaning() {
        return reversed ? reversedMeaning : meaning;
    }

    public boolean isReversed() {
        return reversed;
    }

    public String getOrientation() {
        return reversed ? "Reversed" : "Upright";
    }

    @Override
    public String toString() {
        return name + " (" + getOrientation() + "): " + getMeaning();
    }
}
