package run;

import cards.DeckOfCards;
import cards.PlayingCard;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        ArrayList<PlayingCard> hand = deckOfCards.dealHand(4);
        hand.forEach(PlayingCard::getDetails);
        System.out.println(deckOfCards.sumOfHand(hand));
        System.out.println(deckOfCards.getDeck().size());
        System.out.println(deckOfCards.hasFlush(hand));
        deckOfCards.printHearts(hand);
        System.out.println(deckOfCards.hasQueenOfSpades(hand));
    }
}
