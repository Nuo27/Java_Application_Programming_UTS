
package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;
// the codes below mostly same with add customer controller since they have the same function but the names are diff.
public class AddGameController extends Controller<Kiosk> {
    @FXML private TextField titleTf; // game title
    @FXML private TextField yearTf; // game year
    @FXML private TextField genreTf;// game genre
    @FXML private TextField priceTf;//game price
    @FXML private Text Message;//message
    @FXML private Button addGameBtn;// add btn
   
    public final Kiosk getKiosk() {
        return model;
    }
    //get title in title box /String
    private String getTitle() {
        return titleTf.getText();
    }
    // get years from the input box /int
    private int getYear() {
        return Integer.parseInt(yearTf.getText());
    }
    // get genre for the input box /String
    private String getGenre() {
        return genreTf.getText();
    }
    // get the price of the game from the input /int
    private int getPrice() {
        return Integer.parseInt(priceTf.getText());
    }
    //reset the input box if the user wasn't entering numbers
    @FXML private void initialize() {
        titleTf.textProperty().addListener((o, oldID, newID) ->
            addGameBtn.setDisable(getTitle().isEmpty()));
    }
    // add a game with checking if it's in the system else return notification message
    @FXML private void AddGame(ActionEvent event) {
        try {
            if (!getKiosk().getCatalogue().hasGame(getTitle(), getYear())) {
                getKiosk().getCatalogue().addGame(getTitle(), getYear(), getGenre(), getPrice());
                Message.setText("Game added to Catalogue.");
            }
            else {
                Message.setText("Game already exists.");
            }
        }
        catch (Exception e) {
            Message.setText("Invalid input.");
        }
    }
    //close
    @FXML private void Close(ActionEvent event) {
        stage.close();
    }
}

