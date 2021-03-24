package cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class will represent a full deck of cards. No jokers.
 */
public class DeckOfCards {
    private ArrayList<PlayingCard> deck;
    private Random random = new Random();
    ;

    public DeckOfCards() {
        deck = new ArrayList<>();

        List<Character> suits = PlayingCard.getValidSuits(); // Static method so can be called like this.

        List<Face> faceNames = PlayingCard.getValidFaceNames(); // Static method so can be called like this.

        suits.forEach(type -> faceNames.forEach(value -> deck.add(new PlayingCard(type, value))));
    }

    public ArrayList<PlayingCard> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<PlayingCard> deck) {
        this.deck = deck;
    }

    public Collection<PlayingCard> dealHand(int n) {
        ArrayList<PlayingCard> randomCards = new ArrayList<>();
        if (n > deck.size() || n < 0) {
            n = deck.size();
        }
        for (int i = deck.size(); i > (deck.size() - n); i--) {
            int rand = random.nextInt(i);
            randomCards.add(deck.get(rand));
        }
        return randomCards;
    }

    public int sumOfHand(Collection<PlayingCard> hand){
        AtomicInteger total = new AtomicInteger();

        hand.forEach(s -> {
            total.addAndGet(s.getFace().getFaceValue());
        });
        return total.get();
    }
}
