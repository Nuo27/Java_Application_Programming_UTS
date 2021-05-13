
package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;
import model.Game;

public class ReturnGameController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private Button selectCustomerBtn;
    @FXML private TableView<Game> gamesTv;
    @FXML private Button returnGameBtn;
    @FXML private Text Message;
    
    public final Kiosk getKiosk() {
        return model;
    }
    // same initialization to the rent one, reset the textfield and the select game data if the input doesnt match
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                selectCustomerBtn.setDisable(!idTf.getText().matches("[0-9]+")));
        gamesTv.getSelectionModel().selectedItemProperty().addListener(
                (o, oldGame, newGame) -> returnGameBtn.setDisable(getSelectedGame() == null));
    }
    //get the customer id and transfer it to int
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    // get the selected game
    private Game getSelectedGame() {
        return gamesTv.getSelectionModel().getSelectedItem();
    }
    // selected customer remove rented game
    @FXML private void SelectCustomer(ActionEvent event) {
        try {
            gamesTv.setItems(getKiosk().getCustomer(getID()).currentlyRented());
            Message.setText("");
        }
        catch (Exception e) {
            Message.setText("Invalid Customer ID.");
        }
    }
    // return game to the system
    @FXML private void ReturnGame(ActionEvent event) {
        try {
            getKiosk().getCatalogue().returnGameFromCustomer(
                    getSelectedGame(), getKiosk().getCustomer(getID()));
            Message.setText("Game Returned.");
        }
        catch (Exception e) {
            Message.setText("Invalid Customer ID.");
        }
    }
    //close
    @FXML private void Close(ActionEvent event) {
        stage.close();
    }
}
