package idatg2001.oblig3.cardgame;

import javafx.scene.image.Image;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class will represent a full deck of cards. No jokers.
 * Also contain methods which will be used in teh GUI.
 */
public class DeckOfCards {
    private ArrayList<PlayingCard> deck;
    private Random random;
    private final char[] suits;
    private final int[] faceNames;

    /**
     * Instantiates a new Deck of cards.
     * Creating a deck of 52 cards using the suits and the faces, using two for-each loops
     * it will create an Arraylist<Playingcard> which contains every playing card in the set.
     */
    public DeckOfCards() {
        suits = new char[]{'H', 'D', 'S', 'C'};
        faceNames = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        deck = new ArrayList<>();

        for (char suit : suits) {
            for (int faceName : faceNames) {
                deck.add(new PlayingCard(suit, faceName));
            }
        }
    }

    /**
     * Gets deck.
     *
     * @return the deck
     */
    public ArrayList<PlayingCard> getDeck() {
        return deck;
    }

    /**
     * Sets deck.
     *
     * @param deck the deck
     */
    public void setDeck(ArrayList<PlayingCard> deck) {
        this.deck = deck;
    }

    /**
     * Deals a hand of n cards to the player. Goes through the list and makes sure that
     * the Random clas doesn't create the same int multiple times, as it did when I uses
     * a for-loop.
     *
     * @param n the number of cards to deal.
     * @return the array list of cards which is the cards the player will see.
     */
    public ArrayList<PlayingCard> dealHand(int n) {
        random = new Random();
        ArrayList<PlayingCard> randomCards = new ArrayList<>();
        ArrayList<Integer> randomIntegers = new ArrayList<>();
        Collections.shuffle(randomCards);

        if (n > deck.size() || n < 0) {
            n = deck.size();
        }

        while (randomIntegers.size() <= n) {
            int rand = random.nextInt(deck.size());
            if (!randomIntegers.contains(rand)) {
                randomIntegers.add(rand);
                randomCards.add(deck.get(rand));
            }
        }

        return randomCards;
    }

    /**
     * Uses the integers from the playincards to create a new Integer with the sum of all the cards on hand.
     *
     * @param hand the hand
     * @return the sum of all faces combined
     */
    public int sumOfHand(Collection<PlayingCard> hand) {
        return hand.stream().
                reduce(0, (sum, playingcard) -> sum + playingcard.getFace(), Integer::sum);
    }

    /**
     * Filters out the active cards on the players hand and makes a list of all
     * cards that are of the 'H' suit. Later prints these using a to-string.
     *
     * @param cardsOnHand the cards on hand
     * @return the array list
     */
    public ArrayList<PlayingCard> printHearts(ArrayList<PlayingCard> cardsOnHand) {
        ArrayList<PlayingCard> cardsOfHearts = new ArrayList<>();
        cardsOnHand.stream().
                filter(playingCard -> playingCard.getSuit() == 'H').
                forEach(cardsOfHearts::add);
        return cardsOfHearts;
    }

    /**
     * Checking the active hand if it has a flush, all 5 cards of the same suit.
     *
     * @param cards the cards
     * @return true if all cards are the same suit, false if not.
     */
    public boolean hasFlush(ArrayList<PlayingCard> cards) {
        Map<Character, Long> suitCount = cards.stream().
                collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));

        for (Long number : suitCount.values()) {
            if (number >= 5) {
                return true;
            }
        }
        return false;
    }

    /**
     * Has queen of spades in the active deck, the hand the player has.
     *
     * @param cards the cards
     * @return true if the queen exists, false if she isn't
     */
    public boolean hasQueenOfSpades(ArrayList<PlayingCard> cards) {
        return cards.stream().
                anyMatch(playingCard -> playingCard.getSuit() == 'S' &&
                        playingCard.getFace() == 12);
    }
}
