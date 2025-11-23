import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TarotReader {
    private final List<TarotCardDefinition> deck;
    private final Random random;

    private static class TarotCardDefinition {
        final String name;
        final String uprightMeaning;
        final String reversedMeaning;

        TarotCardDefinition(String name, String uprightMeaning, String reversedMeaning) {
            this.name = name;
            this.uprightMeaning = uprightMeaning;
            this.reversedMeaning = reversedMeaning;
        }
    }

    public TarotReader() {
        this.random = new Random();
        this.deck = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        // Major Arcana
        deck.add(new TarotCardDefinition("The Fool", "New beginnings, spontaneity, innocence", "Recklessness, risk-taking"));
        deck.add(new TarotCardDefinition("The Magician", "Manifestation, resourcefulness, power", "Manipulation, poor planning"));
        deck.add(new TarotCardDefinition("The High Priestess", "Intuition, sacred knowledge, divine feminine", "Secrets, disconnected from intuition"));
        deck.add(new TarotCardDefinition("The Empress", "Femininity, beauty, nature, abundance", "Creative block, dependence on others"));
        deck.add(new TarotCardDefinition("The Emperor", "Authority, establishment, structure, father figure", "Domination, excessive control, rigidity"));
        deck.add(new TarotCardDefinition("The Hierophant", "Spiritual wisdom, religious beliefs, tradition", "Personal beliefs, freedom, challenging status quo"));
        deck.add(new TarotCardDefinition("The Lovers", "Love, harmony, relationships, values alignment", "Self-love, disharmony, imbalance"));
        deck.add(new TarotCardDefinition("The Chariot", "Control, willpower, success, determination", "Self-discipline, opposition, lack of direction"));
        deck.add(new TarotCardDefinition("Strength", "Strength, courage, patience, control", "Self-doubt, weakness, insecurity"));
        deck.add(new TarotCardDefinition("The Hermit", "Soul searching, introspection, inner guidance", "Isolation, loneliness, withdrawal"));
        deck.add(new TarotCardDefinition("Wheel of Fortune", "Good luck, karma, life cycles, destiny", "Bad luck, resistance to change, breaking cycles"));
        deck.add(new TarotCardDefinition("Justice", "Justice, fairness, truth, cause and effect", "Unfairness, lack of accountability, dishonesty"));
        deck.add(new TarotCardDefinition("The Hanged Man", "Pause, surrender, letting go, new perspectives", "Delays, resistance, stalling"));
        deck.add(new TarotCardDefinition("Death", "Endings, change, transformation, transition", "Resistance to change, personal transformation"));
        deck.add(new TarotCardDefinition("Temperance", "Balance, moderation, patience, purpose", "Imbalance, excess, self-healing"));
        deck.add(new TarotCardDefinition("The Devil", "Shadow self, attachment, addiction, restriction", "Releasing limiting beliefs, exploring dark thoughts"));
        deck.add(new TarotCardDefinition("The Tower", "Sudden change, upheaval, chaos, revelation", "Personal transformation, fear of change, averting disaster"));
        deck.add(new TarotCardDefinition("The Star", "Hope, faith, purpose, renewal, spirituality", "Lack of faith, despair, self-trust"));
        deck.add(new TarotCardDefinition("The Moon", "Illusion, fear, anxiety, subconscious", "Release of fear, repressed emotion, inner confusion"));
        deck.add(new TarotCardDefinition("The Sun", "Positivity, fun, warmth, success, vitality", "Inner child, feeling down, overly optimistic"));
        deck.add(new TarotCardDefinition("Judgement", "Judgement, rebirth, inner calling, absolution", "Self-doubt, inner critic, ignoring the call"));
        deck.add(new TarotCardDefinition("The World", "Completion, integration, accomplishment, travel", "Seeking personal closure, short-cuts, delays"));
    }

    public TarotCard drawCard() {
        TarotCardDefinition def = deck.get(random.nextInt(deck.size()));
        boolean reversed = random.nextBoolean();
        return new TarotCard(def.name, def.uprightMeaning, def.reversedMeaning, reversed);
    }

    public List<TarotCard> drawCards(int count) {
        if (count <= 0 || count > deck.size()) {
            throw new IllegalArgumentException("Count must be between 1 and " + deck.size());
        }
        
        // Create a shuffled copy of the deck to ensure unique cards
        List<TarotCardDefinition> shuffledDeck = new ArrayList<>(deck);
        Collections.shuffle(shuffledDeck, random);
        
        List<TarotCard> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            TarotCardDefinition def = shuffledDeck.get(i);
            boolean reversed = random.nextBoolean();
            cards.add(new TarotCard(def.name, def.uprightMeaning, def.reversedMeaning, reversed));
        }
        return cards;
    }

    public void performReading(String question, int numberOfCards) {
        System.out.println("\n🔮 Tarot Reading 🔮");
        System.out.println("Your question: " + question);
        System.out.println("\nShuffling the cards...");
        
        try {
            Thread.sleep(1000); // Dramatic pause
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        List<TarotCard> cards = drawCards(numberOfCards);
        
        System.out.println("\nYour reading:");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + cards.get(i));
        }
        
        System.out.println("\n✨ May this reading guide you on your path. ✨\n");
    }
}
