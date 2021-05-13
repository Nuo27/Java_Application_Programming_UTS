package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import model.Kiosk;
import model.Game;

public class ShowGamesByYearController  extends Controller<Kiosk> {
    @FXML private ListView<Integer> yearsLv;// year to classify
    @FXML private TableView<Game> gamesTv;//games :)
    @FXML private Button displayGamesBtn;//display btn
    
    public final Kiosk getKiosk() {
        return model;
    }
    // initialize it if wrong selection made
    @FXML private void initialize() {
        yearsLv.getSelectionModel().selectedItemProperty().addListener(
        (o, oldYear, newYear) -> displayGamesBtn.setDisable(getSelectedYear() == 0));
    }
    // select a year
    private int getSelectedYear() {
        return yearsLv.getSelectionModel().getSelectedItem();
    }
    //display games in selected year
    @FXML private void DisplayGames(ActionEvent event) {
        gamesTv.setItems(getKiosk().getCatalogue().getGamesByYear(getSelectedYear()));
    }
    // close 
    @FXML private void Close(ActionEvent event) {
        stage.close();
    }
}