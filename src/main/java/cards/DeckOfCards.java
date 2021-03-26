package cards;

import java.util.*;

/**
 * This class will represent a full deck of cards. No jokers.
 */
public class DeckOfCards {
    private ArrayList<PlayingCard> deck;
    private Random random = new Random();

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

    public ArrayList<PlayingCard> dealHand(int n) {
        ArrayList<PlayingCard> randomCards = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Collections.shuffle(randomCards);

        if (n > deck.size() || n < 0) {
            n = deck.size();
        }

        while (list.size() <= n) {
            int rand = random.nextInt(deck.size());
            if (!list.contains(rand)) {
                list.add(rand);
                randomCards.add(deck.get(rand));
            }
        }

        removeList(randomCards);

        return randomCards;
    }

    public void removeList(List<PlayingCard> cardsThatMatch) {
        deck.removeAll(cardsThatMatch);
    }

    public void getFullDeck() {
        deck.clear();
        new DeckOfCards();
    }

    public int sumOfHand(ArrayList<PlayingCard> hand) {
        return hand.stream().
                reduce(0, (sum, playingcard) -> sum + playingcard.getFace().getFaceValue(), Integer::sum);
    }
}
