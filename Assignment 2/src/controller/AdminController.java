package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.*;
import javafx.event.*;
import javafx.stage.*;
import model.Kiosk;



public class AdminController extends Controller<Kiosk> {
    public final Kiosk getKiosk() {
        return model;
    }
    //trigger of opening show all customers window
    @FXML private void ShowAllCustomers(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowAllCustomers.fxml", "Show All Customers", new Stage());
    }
    //trigger of opening show all games window
    @FXML private void ShowAllGames(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowAllGames.fxml", "Show All Games", new Stage());
    }
    //trigger of opening add customer window
    @FXML private void ShowAddCustomer(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/AddCustomer.fxml", "Add Customer", new Stage());
    }
    //trigger of opening add game window
    @FXML private void ShowAddGame(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/AddGame.fxml", "Add Game", new Stage());
    }
    //trigger of opening remove customer window
    @FXML private void ShowRemoveCustomer(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/RemoveCustomer.fxml", "Remove Customer", new Stage());
    } 
    //trigger of opening remove customer window
    @FXML private void ShowRemoveGame(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/RemoveGame.fxml", "Remove Game", new Stage());
    }
    //close the window
    @FXML private void Close(ActionEvent event) {
        stage.close();
    }
    
}
