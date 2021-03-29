package idatg2001.oblig3.cardgame;

import javafx.scene.image.Image;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class will represent a full deck of cards. No jokers.
 */
public class DeckOfCards {
    private ArrayList<PlayingCard> deck;
    private Random random;
    private final char[] suits;
    private final int[] faceNames;
    private Image backOfCardImage;

    public DeckOfCards() {
        suits = new char[]{'H', 'D', 'S', 'C'};
        faceNames = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        deck = new ArrayList<>();

        for(char suit : suits){
            for(int faceName : faceNames){
                deck.add(new PlayingCard(suit, faceName));
            }
        }


        backOfCardImage = new Image("/images/backOfCard.png");
    }

    public ArrayList<PlayingCard> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<PlayingCard> deck) {
        this.deck = deck;
    }

    public Image getBackOfCardImage() {
        return backOfCardImage;
    }

    public void setBackOfCardImage(Image backOfCardImage) {
        this.backOfCardImage = backOfCardImage;
    }

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

    public int sumOfHand(Collection<PlayingCard> hand){
        return hand.stream().
                reduce(0, (sum, playingcard) -> sum + playingcard.getFace(), Integer::sum);
    }

    public ArrayList<PlayingCard> printHearts(ArrayList<PlayingCard> cardsOnHand){
        ArrayList<PlayingCard> cardsOfHearts = new ArrayList<>();
        cardsOnHand.stream().
                filter(playingCard -> playingCard.getSuit() == 'H').
                forEach(cardsOfHearts::add);
        return cardsOfHearts;
    }
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

    public boolean hasQueenOfSpades(ArrayList<PlayingCard> cards){
        return cards.stream().
                anyMatch(playingCard -> playingCard.getSuit() == 'S' &&
                        playingCard.getFace() == 12);
    }
}
