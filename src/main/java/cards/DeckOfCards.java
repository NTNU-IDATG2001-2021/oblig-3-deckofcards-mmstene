package cards;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will represent a full deck of cards. No jokers.
 */
public class DeckOfCards {
    private ArrayList<PlayingCard> deck;

    public DeckOfCards() {
        deck = new ArrayList<>();

        List<Character> suits = PlayingCard.getValidSuits(); // Static method so can be called like this.

        List<String> faceNames = PlayingCard.getValidFaceNames(); // Static method so can be called like this.

        for (Character suit : suits) {
            for (String faces:faceNames){
                deck.add(new PlayingCard(suit,faces));
            }
        }
    }

    public ArrayList<PlayingCard> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<PlayingCard> deck) {
        this.deck = deck;
    }


}
