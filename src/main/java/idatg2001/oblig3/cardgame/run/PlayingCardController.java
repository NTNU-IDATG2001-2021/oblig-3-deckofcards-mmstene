package idatg2001.oblig3.cardgame.run;

import idatg2001.oblig3.cardgame.DeckOfCards;
import idatg2001.oblig3.cardgame.PlayingCard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayingCardController implements Initializable {
    DeckOfCards deck;


    /*
    * Using @FXML to be able to have my variables private and still accessed within the .fxml file.
     */
    @FXML private ImageView cardToShow1;
    @FXML private ImageView cardToShow2;
    @FXML private ImageView cardToShow3;
    @FXML private ImageView cardToShow4;
    @FXML private ImageView cardToShow5;

    @FXML
    private TextField sumOfHand;
    @FXML
    private TextField doesHaveFlush;
    @FXML
    private TextField doesQueenOfSpadesExist;
    @FXML
    private TextField cardsOfHearts;


    @FXML private Button dealHandButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new DeckOfCards();
        cardToShow1.setImage(deck.getBackOfCardImage());
        cardToShow2.setImage(deck.getBackOfCardImage());
        cardToShow3.setImage(deck.getBackOfCardImage());
        cardToShow4.setImage(deck.getBackOfCardImage());
        cardToShow5.setImage(deck.getBackOfCardImage());
    }

    @FXML
    public void nextCardButtonPushed(ActionEvent actionEvent) {
        ArrayList<PlayingCard> list = deck.dealHand(4);

        cardToShow1.setImage(list.get(0).getImage());
        cardToShow2.setImage(list.get(1).getImage());
        cardToShow3.setImage(list.get(2).getImage());
        cardToShow4.setImage(list.get(3).getImage());
        cardToShow5.setImage(list.get(4).getImage());

        sumOfHand.setText(String.valueOf(deck.sumOfHand(list)));
        doesHaveFlush.setText(String.valueOf(deck.hasFlush(list)));
        doesQueenOfSpadesExist.setText(String.valueOf(deck.hasQueenOfSpades(list)));
        if((deck.printHearts(list).size() != 0)){
            cardsOfHearts.setText(deck.printHearts(list).toString());
        }else{
            cardsOfHearts.setText("");
        }
    }
}
