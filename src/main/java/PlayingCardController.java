import cards.DeckOfCards;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayingCardController implements Initializable {

    /*
    * Using @FXML to be able to have my variables private and still accessed within the .fxml file.
     */
    @FXML private ImageView CardToShowOne;
    @FXML private ImageView CardToShowTwo;
    @FXML private ImageView CardToShowThree;
    @FXML private ImageView CardToShowFour;
    @FXML private ImageView CardToShowFive;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DeckOfCards deck = new DeckOfCards();
    }
}
