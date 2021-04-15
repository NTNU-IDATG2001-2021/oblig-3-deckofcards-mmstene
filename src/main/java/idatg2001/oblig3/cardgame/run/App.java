package idatg2001.oblig3.cardgame.run;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type App.
 */
public class App extends Application {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.
                load((getClass().getClassLoader().getResource("PlayingCardView.fxml")));
        Scene scene = new Scene(root);

        primaryStage.setTitle("The best card game ever");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
