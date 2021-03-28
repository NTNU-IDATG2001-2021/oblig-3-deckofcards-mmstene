package idatg2001.oblig3.cardgame.run;

import idatg2001.oblig3.cardgame.DeckOfCards;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayingCardController implements Initializable {
    /*
    * Using @FXML to be able to have my variables private and still accessed within the .fxml file.
     */
    @FXML private ImageView cardToShow1;
    @FXML private ImageView cardToShow2;
    @FXML private ImageView cardToShow3;
    @FXML private ImageView cardToShow4;
    @FXML private ImageView cardToShow5;


    @FXML private Button dealHandButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DeckOfCards deck = new DeckOfCards();
        cardToShow1.setImage(deck.getBackOfCardImage());
    }
}
