package idatg2001.oblig3.cardgame;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Collections;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class will represent a full deck of cards. No jokers.
 */
public class DeckOfCards {
    private ArrayList<PlayingCard> deck;
    private Random random;
    private Image backOfCardImage;

    public DeckOfCards(ArrayList<PlayingCard> deck) {
        this.deck = deck;
        //backOfCardImage = new Image("./resources/images/2_of_clubs.png");
    }

    public DeckOfCards() {
        deck = new ArrayList<>();

        List<Character> suits = PlayingCard.getValidSuits(); // Static method so can be called like this.
        List<Face> faceNames = PlayingCard.getValidFaceNames(); // Static method so can be called like this.

        suits.forEach(type -> faceNames.forEach(value -> deck.add(new PlayingCard(type, value))));

        //backOfCardImage = new Image();
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
        List<Integer> randomIntegers = new ArrayList<>();
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
                reduce(0, (sum, playingcard) -> sum + playingcard.getFace().getFaceValue(), Integer::sum);
    }

    public void printHearts(ArrayList<PlayingCard> cardsOnHand){
        cardsOnHand.stream().
                filter(playingCard -> playingCard.getSuit() == 'H').
                forEach(PlayingCard::getDetails);
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
                        playingCard.getFace().getFaceValue() == 12);
    }
}
