import cards.DeckOfCards;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayingCardController implements Initializable {

    @FXML
    private ImageView CardToShowOne;
    private ImageView CardToShowTwo;
    private ImageView CardToShowThree;
    private ImageView CardToShowFour;
    private ImageView CardToShowFive;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DeckOfCards deck = new DeckOfCards();
    }
}
