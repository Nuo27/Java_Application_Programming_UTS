
package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import au.edu.uts.ap.javafx.Controller;
import model.Kiosk;


public class CatalogueController extends Controller<Kiosk>{
    public final Kiosk getKiosk(){
        return model;
    }
// There're "View Games by All, Available, Genre and Year", "Rent a game" and "Return a game" in the catalogue menu.
    
    //Click to show all games
    @FXML private void ShowAllGames(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowAllGames.fxml", "All Games", new Stage());
    }
    //Click to show available games
    @FXML private void ShowAvailableGames(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowAvailableGames.fxml", "Available Games", new Stage());
    }
    //Click to show games by genre
    @FXML private void ShowGamesByGenre(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowGamesByGenre.fxml", "Games by Genre", new Stage());
    }
    //Click to show games by year
    @FXML private void ShowGamesByYear(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowGamesByYear.fxml", "Games by Year", new Stage());
    }
    //Click to rent a game
    @FXML private void ShowRentGame(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/RentGame.fxml", "Rent a Game", new Stage());
    }
    //Click to return a game
    @FXML private void ShowReturnGame(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ReturnGame.fxml", "Return a Game", new Stage());
    }
    //Click to close the window
    @FXML private void Close(ActionEvent event) {
        stage.close();
    }
    
}
