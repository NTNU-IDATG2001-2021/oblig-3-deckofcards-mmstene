package run;
import cards.DeckOfCards;
import cards.PlayingCard;

import java.util.Collection;

public class App {
    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        Collection<PlayingCard> hand = deckOfCards.dealHand(2);
        System.out.println(hand);
        System.out.println(deckOfCards.sumOfHand(hand));
    }
}
