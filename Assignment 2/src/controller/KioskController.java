package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Kiosk;

public class KioskController extends Controller<Kiosk> {
    //dont know yet
     @FXML
     public void initialize() {

    }   
    
    public final Kiosk getKiosk() {
        return model;
    }
    
  //click to open catelogue menu
    @FXML
    private void ShowCatalogueMenu(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/Catalogue.fxml", "Catalogue", new Stage());
    }
    //click to open customer menu
    @FXML
    private void ShowCustomerRecord(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/CustomerRecord.fxml", "Patron Record", new Stage());
    }
    //click to open top-up account menu, pos: 3
    @FXML
    private void ShowTopUpAccount(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/TopUpAccount.fxml", "Account Top-up", new Stage());
    }
    //click to open fav games, pos: 4
    @FXML
    private void ShowFavouriteGames(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/FavouriteGames.fxml", "Favourites", new Stage());
    }
    //click to open admin menu, pos: above fav movie
    @FXML
    private void ShowAdminMenu(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/Admin.fxml", "Administration Menu", new Stage());
    }
    //click to quit button, pos: down below
    @FXML
    private void Close(ActionEvent event) {
        stage.close();
    }
}
