package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;
import model.Game;

public class RentGameController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private Button selectCustomerBtn;
    @FXML private TableView<Game> gamesTv;
    @FXML private Button rentGameBtn;
    @FXML private Text Message;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    //reset the textfield and the select game data if the input doesnt match
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                selectCustomerBtn.setDisable(!idTf.getText().matches("[0-9]+")));
        gamesTv.getSelectionModel().selectedItemProperty().addListener(
                (o, oldGame, newGame) -> rentGameBtn.setDisable(getSelectedGame() == null));
    }
    // get the id and transfer to int
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    //get the selected game
    private Game getSelectedGame() {
        return gamesTv.getSelectionModel().getSelectedItem();
    }
    
    // check the customer in the library
    @FXML private void SelectCustomer(ActionEvent event) {
        if (getKiosk().getCustomer(getID()) != null) {
            gamesTv.setItems(getKiosk().getCatalogue().getAvailableGames());
            Message.setText("");
        }
        else {
            Message.setText("Invalid Customer ID.");
        }
    }
    // rent the game selected
    @FXML private void RentGame(ActionEvent event) {
        try {
            if (getKiosk().getCatalogue().rentGameToCustomer(
                    getSelectedGame(), getKiosk().getCustomer(getID()))) {
                Message.setText("Game Rented.");
            }
            else {
                Message.setText("Insufficient funds.");
            }
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