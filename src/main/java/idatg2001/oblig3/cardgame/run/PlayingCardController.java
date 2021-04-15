package idatg2001.oblig3.cardgame.run;

import idatg2001.oblig3.cardgame.DeckOfCards;
import idatg2001.oblig3.cardgame.PlayingCard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * The type Playing card controller.
 */
public class PlayingCardController implements Initializable {
    /**
     * The Deck.
     */
    DeckOfCards deck;
    /*
     * Using @FXML to be able to have my variables private and still accessed within the .fxml file.
     */
    @FXML
    private ImageView cardToShow1;
    @FXML
    private ImageView cardToShow2;
    @FXML
    private ImageView cardToShow3;
    @FXML
    private ImageView cardToShow4;
    @FXML
    private ImageView cardToShow5;

    @FXML
    private TextField sumOfHand;
    @FXML
    private TextField doesHaveFlush;
    @FXML
    private TextField doesQueenOfSpadesExist;
    @FXML
    private TextField cardsOfHearts;


    @FXML
    private Button dealHandButton;

    /**
     * Initializing the GUI with setting the images of the backofcards.
     * Also initializing the deckofcards.
     *
     * @param url
     * @param resourceBundle
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new DeckOfCards();
        cardToShow1.setImage(initializeBackOfCardImage());
        cardToShow2.setImage(initializeBackOfCardImage());
        cardToShow3.setImage(initializeBackOfCardImage());
        cardToShow4.setImage(initializeBackOfCardImage());
        cardToShow5.setImage(initializeBackOfCardImage());
    }

    /**
     * Get the backofcard image.
     *
     * @return the backOfCard image
     */
    @FXML
    private Image initializeBackOfCardImage() {
        return new Image(Objects.requireNonNull(
                getClass().getResourceAsStream("/images/backOfCard.png")));
    }

    /**
     * Does everything that is showed to the user in the program.
     * Sets the images of the 5 cards by using the method @getImage()
     * Next it uses the TextFields and puts the values into Strings to show the user the results.
     *
     * @param actionEvent
     */
    @FXML
    private void nextCardButtonPushed(ActionEvent actionEvent) {
        ArrayList<PlayingCard> list = deck.dealHand(4);

        cardToShow1.setImage(getImage(list, 0));
        cardToShow2.setImage(getImage(list, 1));
        cardToShow3.setImage(getImage(list, 2));
        cardToShow4.setImage(getImage(list, 3));
        cardToShow5.setImage(getImage(list, 4));


        sumOfHand.setText(String.valueOf(deck.sumOfHand(list)));
        doesHaveFlush.setText(String.valueOf(deck.hasFlush(list)));
        doesQueenOfSpadesExist.setText(String.valueOf(deck.hasQueenOfSpades(list)));
        if ((deck.printHearts(list).size() != 0)) {
            cardsOfHearts.setText(deck.printHearts(list).toString());
        } else {
            cardsOfHearts.setText("");
        }
    }

    /**
     * Gets the images needed for the program to show the right cards when they are
     * displayed to the user.
     *
     * @param list
     * @param index
     * @return images of the cards.
     */
    @FXML
    private Image getImage(ArrayList<PlayingCard> list, int index) {
        return new Image(Objects.requireNonNull(
                getClass().getResourceAsStream("/images/" + list.get(index).getCardFaceAndSuit())));
    }
}
