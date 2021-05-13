package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;

public class TopUpAccountController extends Controller<Kiosk> {
    @FXML private Text Message;
    @FXML private TextField idTf;
    @FXML private TextField amountTf;
    @FXML private Button topUpBtn;
    
    public final Kiosk getKiosk() {
        return model;
    }
    // get user id and transfer to int
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    //get user charge amount and transfer to int
    private int getAmount() {
        return Integer.parseInt(amountTf.getText());
    }
    //initialize the textfield if the input isnt number
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                topUpBtn.setDisable(!idTf.getText().matches("[0-9]+")));
    }
    // topup to the account and send message
    @FXML private void TopUp(ActionEvent event) {
        try {
            getKiosk().topUpAccount(getKiosk().getCustomer(getID()), getAmount());
            Message.setText("Transaction Complete.");
        }
        catch (NullPointerException e) {
            Message.setText("Invalid Customer ID.");
        }
        catch (NumberFormatException e) {
            Message.setText("Invalid Amount.");
        }
    }
    //close
    @FXML private void Close(ActionEvent event) {
        stage.close();
    }
}
