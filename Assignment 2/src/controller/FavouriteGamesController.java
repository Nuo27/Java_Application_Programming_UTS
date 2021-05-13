
package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;
import model.Game;

public class FavouriteGamesController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private Button selectCustomerBtn;
    @FXML private Text Message;
    @FXML private TableView<Game> favGameTv;
    
    public final Kiosk getKiosk() {
        return model;
    }
    // get the id and transfer to int
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    // reset reset reset the box if input isn't number
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                selectCustomerBtn.setDisable(!idTf.getText().matches("[0-9]+")));
    }
    //check input customer's fav games
    @FXML private void SelectCustomer(ActionEvent event) {
        try {
            favGameTv.setItems(getKiosk().getCustomer(getID()).favouriteGames());
            Message.setText("");
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

