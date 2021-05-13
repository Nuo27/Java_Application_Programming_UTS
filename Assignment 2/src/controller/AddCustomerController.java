
package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;

public class AddCustomerController extends Controller<Kiosk> {
    @FXML private TextField idTf;//Customer id
    @FXML private TextField nameTf;//Customer name
    @FXML private TextField balanceTf;//Customer balance
    @FXML private Text Message;//return message
    @FXML private Button addCustomerBtn;//add btn
    
    public final Kiosk getKiosk() {
        return model;
    }
    // to get ID user put in and transfer it to int
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    // get name user put in in string
    private String getName() {
        return nameTf.getText();
    }
    // get balance user put in and transfer it to int
    private int getBalance() {
        return Integer.parseInt(balanceTf.getText());
    }
    //reset the textfield if the user didnt enter numbers
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                addCustomerBtn.setDisable(!idTf.getText().matches("[0-9]+")));
    }
    // add a customer, check if the id is in the system, only allow adding if there's no, or return notification message.
    @FXML private void AddACustomer(ActionEvent event) {
        try {
            if (getKiosk().getCustomer(getID()) == null) {
                getKiosk().addCustomer(getID(), getName(), getBalance());
                Message.setText("Customer added to Kiosk.");
            }
            else {
                Message.setText("Customer ID already exists.");
            }
        }
        catch (Exception e) {
            Message.setText("Invalid input.");
        }
    }
    //close the window
    @FXML private void Close(ActionEvent event) {
        stage.close();
    }
}
