import java.util.ArrayList;
import java.util.List;

public class Game {
	private String title; 
	private int year; 
	private int price; 
	private Genre genre;
		// write your solution here

	public Game(String title, int year, Genre genre, int price) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.price = price;
    }
    
    public void returnGamePrintln() {
        System.out.println(title + " has been returned.");
    }
    
    public boolean hasType(String title) {
        return this.title.equals(title);
    }
    
    public boolean hasGenre(String genre) {
        return this.genre.hasType(genre);
    }
    
    public boolean hasYear(int year) {
        return this.year == year;
    }
    
    public int getPrice() {
        return price;
    }
    public Genre getGenre(){
        return this.genre; 
    }
    
    @Override
    public String toString() {
        return year + "\t" + title + "\t" + genre + "\t$" + price;
    }
}
