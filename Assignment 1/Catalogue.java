import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	private Kiosk kiosk;
	private List<Game> gamesAvailable;
	private List<Game> gamesRented; 
	private List<Genre> genres;

    		// write your solution here
	public Catalogue(Kiosk kiosk) {
        this.kiosk = kiosk;
        genres = new ArrayList<Genre>();
        gamesAvailable = new ArrayList<Game>();
        gamesAvailable.add(new Game("Robinson Crusoe", 2012, new Genre("Action Queue"), 3));
        gamesAvailable.add(new Game("Talisman", 2007,new Genre("Role Playing"), 4));
        gamesAvailable.add(new Game("Three Kingdoms Redux", 2014,new Genre("Hand Management"), 3));
        gamesAvailable.add(new Game("Dungeons & Dragons", 2010, new Genre("Modular Board"), 4));
        gamesAvailable.add(new Game("Elder Sign", 2011, new Genre("Modular Board"), 3));
        gamesRented = new ArrayList<Game>();
        for(Game game : gamesAvailable)
        {
            genres.add(game.getGenre());
        }
    }
    
    public void listAvailableGames() {
        for (Game game: gamesAvailable) {
            System.out.println(game);
        }
    }
        
    public void listRentedGames() {
        for (Game game: gamesRented) {
            System.out.println(game);
        }
    }
    
    public void listGamesByGenre(String genre) {
        for (Game game: gamesAvailable) {
            if (game.hasGenre(genre)) {
                System.out.println(game);
            }
        }
        for (Game game: gamesRented) {
            if (game.hasGenre(genre)) {
                System.out.println(game);
            }
        }
    }
    
    public void listGamesByYear(int year) {
        for (Game game: gamesAvailable) {
            if (game.hasYear(year)) {
                System.out.println(game);
            }
        }
        for (Game game: gamesRented) {
            if (game.hasYear(year)) {
               System.out.println(game);
            }
        }
    }
    
    public void listGenres() {
        for (Genre genre: genres) {
            System.out.println(genre);
        }
    }
    
    public void rentGame(Game game) {
        gamesAvailable.remove(game);
        gamesRented.add(game);
    }
    
    public void returnGame (Game game) {
        gamesAvailable.add(game);
        gamesRented.remove(game);
    }
    
    public void addGame(String title, int year, String genre, int price) {
        gamesAvailable.add(new Game(title, year, genre(genre), price));
    }
    
    public void removeGame(Game game) {
        gamesAvailable.remove(game);
        gamesRented.remove(game);
    }
    
    public Game game(String title) {
        for (Game game: gamesAvailable) {
            if (game.hasType(title)) {
                return game;
            }
        }
        for (Game game: gamesRented) {
            if (game.hasType(title)) {
                return game;
            }
        }
        return null;
    }
    
    public Game game2(String title, int year) {
        for (Game game: gamesAvailable) {
            if (game.hasType(title) && game.hasYear(year)) {
                return game;
            }
        }
        for (Game game: gamesRented) {
            if (game.hasType(title) && game.hasYear(year)) {
                return game;
            }
        }
        return null;
    }
    
    public Genre genre(String name) {
        for (Genre genre: genres) {
            if (genre.hasType(name)) {
                return genre;
            }
        }
        return null;
    }
    
    public boolean hasGame(String title, int year, String genre) {
        for (Game game: gamesAvailable) {
            if (game.hasType(title) && game.hasYear(year) && game.hasGenre(genre)) {
                return true;
            }
        }
        for (Game game: gamesRented) {
            if (game.hasType(title) && game.hasYear(year) && game.hasGenre(genre)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isGameAvailable(Game game) {
        return gamesAvailable.contains(game);
    }
}
