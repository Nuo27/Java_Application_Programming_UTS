package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import model.Kiosk;
import model.Customer;
public class RemoveCustomerController extends Controller<Kiosk> {
    @FXML private TableView<Customer> customersTv;
    @FXML private Button removeCustomerBtn;
    
    @FXML private void initialize() {
        customersTv.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Customer> observable, Customer oldCustomer, Customer newCustomer) -> {
            removeCustomerBtn.setDisable(getSelectedCustomer() == null);
        });
    }
    public final Kiosk getKiosk() {
        return model;
    }
    // to check the customer input in the system
    private Customer getSelectedCustomer() {
        return customersTv.getSelectionModel().getSelectedItem();
    }
    // reset the box if input isnt numbers
    
    // remove the customer
    @FXML private void RemoveCustomer(ActionEvent event) {
        getKiosk().removeCustomer(getSelectedCustomer());
    }
    //close
    @FXML private void Close(ActionEvent event) {
        stage.close();
    }
}
