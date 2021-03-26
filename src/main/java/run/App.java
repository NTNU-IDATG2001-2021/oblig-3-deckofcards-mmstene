package run;

import cards.DeckOfCards;
import cards.PlayingCard;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        ArrayList<PlayingCard> hand = deckOfCards.dealHand(4);
        System.out.println(hand);
        System.out.println(deckOfCards.sumOfHand(hand));
        System.out.println(deckOfCards.getDeck().size());
        deckOfCards.getFullDeck();
        System.out.println(deckOfCards.getDeck().size());
    }
}
