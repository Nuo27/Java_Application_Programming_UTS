package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import model.Kiosk;




//simple show function 
public class ShowAvailableGamesController extends Controller<Kiosk> {
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML private void Close(ActionEvent event) {
        stage.close();
    }
}