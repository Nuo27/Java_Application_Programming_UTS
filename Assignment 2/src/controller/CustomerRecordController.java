
package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;
import model.Game;


public class CustomerRecordController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private Button selectCustomerBtn;
    @FXML private Text Message;
    @FXML private TableView<Game> rentedGamesTv;
    @FXML private TableView<Game> rentHistoryTv;
    
    public final Kiosk getKiosk() {
        return model;
    }
    //get the id and transfer to int
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    //reset the iuput box if the user input things other than numbers
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                selectCustomerBtn.setDisable(!idTf.getText().matches("[0-9]+")));
    }
    //to check the input customer's rented game and history and return message
    @FXML
    private void SelectCustomer(ActionEvent event) {
        try {
            rentedGamesTv.setItems(getKiosk().getCustomer(getID()).currentlyRented());
            rentHistoryTv.setItems(getKiosk().getCustomer(getID()).rentingHistory());
            Message.setText(getKiosk().getCustomer(getID()).toString());
        }
        catch (Exception e) {
            Message.setText("Invalid Customer ID.");
        }
    }
    //close
    @FXML
    private void Close(ActionEvent event) {
        stage.close();
    }
}

