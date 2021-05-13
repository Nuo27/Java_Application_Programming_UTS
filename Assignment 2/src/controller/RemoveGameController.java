package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import model.Kiosk;
import model.Game;

public class RemoveGameController extends Controller<Kiosk> {
    @FXML private TableView<Game> gamesTv;
    @FXML private Button removeGameBtn;
    
    public final Kiosk getKiosk() {
        return model;
    }
    //check input game in the library
    private Game getSelectedGame() {
        return gamesTv.getSelectionModel().getSelectedItem();
    }
    // reset if input doesnt match
    @FXML private void initialize() {
        gamesTv.setItems(getKiosk().getCatalogue().getAllGames());
        gamesTv.getSelectionModel().selectedItemProperty().addListener(
        (o, oldGame, newGame) -> removeGameBtn.setDisable(getSelectedGame() == null));
    }
    // remove the game
    @FXML private void RemoveGame(ActionEvent event) {
        getKiosk().getCatalogue().removeGame(getSelectedGame());
        gamesTv.setItems(getKiosk().getCatalogue().getAllGames());
    }
    //close
    @FXML private void Close(ActionEvent event) {
        stage.close();
    }
}
