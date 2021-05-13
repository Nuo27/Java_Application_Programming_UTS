package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import model.Kiosk;
import model.Genre;
import model.Game;

public class ShowGamesByGenreController extends Controller<Kiosk> {
    @FXML private ListView<Genre> genresLv;//genre to classify
    @FXML private TableView<Game> gamesTv;//show games
    @FXML private Button displayGamesBtn;// display btn
    
    public final Kiosk getKiosk() {
        return model;
    }
    //same initialization all the way down
    @FXML private void initialize() {
        genresLv.getSelectionModel().selectedItemProperty().addListener(
        (o, oldGenre, newGenre) -> displayGamesBtn.setDisable(getSelectedGenre() == null));
    }
    // selected a genre
    private Genre getSelectedGenre() {
        return genresLv.getSelectionModel().getSelectedItem();
    }
    
    // shows games of selected genre
    @FXML
    private void DisplayGames(ActionEvent event) {
        gamesTv.setItems(getKiosk().getCatalogue().getGamesInGenre(getSelectedGenre()));
    }
    //close
    @FXML
    private void Close(ActionEvent event) {
        stage.close();
    }
}