module IDATG.Oblig {
    requires javafx.controls;
    requires javafx.fxml;
    opens idatg2001.oblig3.cardgame.run to javafx.fxml;
    opens idatg2001.oblig3.cardgame;
    exports idatg2001.oblig3.cardgame.run;
}