import idatg2001.oblig3.cardgame.DeckOfCards;
import idatg2001.oblig3.cardgame.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    public DeckOfCards deckOfCards;
    public ArrayList<PlayingCard> hand;

    @BeforeEach
    void start() {
        deckOfCards = new DeckOfCards();
        hand = new ArrayList<>();
    }

    @Test
    @DisplayName("Testing to see if the size of the list is 5 cards after using the method.")
    void dealHand() {
        hand.addAll(deckOfCards.dealHand(4));
        assertEquals(5, hand.size());
    }

    @Test
    @DisplayName("Testing to see if the sum changes after using the method")
    void sumOfHand() {
        int before = 0;
        int after = deckOfCards.sumOfHand(deckOfCards.dealHand(0));
        assertNotEquals(before, after);

    }

    @Test
    @DisplayName("Checking if the method picks up every card of hearts.")
    void printHearts() {
        hand.addAll(deckOfCards.dealHand(51));
        assertEquals(13,deckOfCards.printHearts(hand).size());
    }

    @Test
    @DisplayName("Checking if the method returns true if all cards are of the same suit.")
    void hasFlush() {
        hand.addAll(deckOfCards.dealHand(51));
        assertTrue(deckOfCards.hasFlush(hand));
    }

    @Test
    @DisplayName("Checking if the methods returns true when the queen of spades is in the deck")
    void hasQueenOfSpades() {
        hand.addAll(deckOfCards.dealHand(51));
        assertTrue(deckOfCards.hasQueenOfSpades(hand));
    }

    @Test
    @DisplayName("Checking if the deck contains 52 cards.")
    void getDeck() {
        assertEquals(52, deckOfCards.getDeck().size());
    }
}