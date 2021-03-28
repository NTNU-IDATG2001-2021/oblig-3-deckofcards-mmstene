package idatg2001.oblig3.cardgame;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a playing card. A playing card has a number (face) between
 * 1 and 13, where 1 is called an Ace, 11 = Knight, 12 = Queen and 13 = King.
 * The card can also be one of 4 suits: Spade, Heart, Diamonds and Clubs.
 *
 * @author ntnu
 * @version 2020-01-10
 */
public class PlayingCard {

    private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    private final Face face; // a number between 1 and 13
    private Image image;

    /**
     * Creates an instance of a cards.PlayingCard with a given suit and face.
     *
     * @param suit The suit of the card, as a single character. 'S' for Spades,
     *             'H' for Heart, 'D' for Diamonds and 'C' for clubs
     * @param face The face value of the card, an integer between 1 and 13
     */
    public PlayingCard(char suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    /**
     * Returns the suit and face of the card as a string.
     * A 4 of hearts is returned as the string "H4".
     *
     * @return the suit and face of the card as a string
     */
    public String getAsString() {
        return String.format("%s %s", suit, face);
    }

    /**
     * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for clubs
     *
     * @return the suit of the card
     */
    public char getSuit() {
        return suit;
    }

    /**
     * Returns the face of the card (value between 1 and 13).
     *
     * @return the face of the card
     */
    public Face getFace() {
        return face;
    }

    public static List<Character> getValidSuits(){
        return Arrays.asList('S','H','D','C');
    }

    public static List<Face> getValidFaceNames(){
        return Arrays.asList(new Face(2),
                new Face(3),
                new Face(4),
                new Face(5),
                new Face(6),
                new Face(7),
                new Face(8),
                new Face(9),
                new Face(10),
                new Face(11,"Jack"),
                new Face(12,"Queen"),
                new Face(13,"King"),
                new Face(1,"Ace"));
    }

    public void getDetails(){
        System.out.println(getAsString());
    }
}
