import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Customer {
	private int ID; 
	private String name; 
	private int balance;
	private List<Game> currentlyRented; 
	private List<Game> rentingHistory;

		// write your solution here
	//create customers info
    public Customer(int ID, String name, int balance) {
        this.ID = ID;
        this.name = name;
        this.balance = balance;
        currentlyRented = new ArrayList<Game>();
        rentingHistory = new ArrayList<Game>();
    }

    public void viewRecord() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Balance: $" + balance);
        System.out.println("Games currently rented by " + name + ":");
        listCurrentlyRentedGames();
        System.out.println(name + "'s renting history:");
        listRentingHistory();
    }
    //to rank fav games
    public void showFavouriteGames() {
        System.out.println(name + "'s favourite games are:");
        if (!rentingHistory.isEmpty()) {
            ArrayList<Game> uniqueRentalHistory = new ArrayList<Game>();
            ArrayList<Integer> rentalTimes = new ArrayList<Integer>();
            for (Game game: rentingHistory) {
                if (!uniqueRentalHistory.contains(game)) {
                    uniqueRentalHistory.add(game);
                }
            }
            for (Game game: uniqueRentalHistory) {
                rentalTimes.add(Collections.frequency(rentingHistory, game));
            }
            int mostTimes = 0;
            int secondmostTimes = 0;
            int thirdmostTimes = 0;
            for (int i: rentalTimes) {
                if (i >= mostTimes) {
                    thirdmostTimes = secondmostTimes;
                    secondmostTimes = mostTimes;
                    mostTimes = i;
                }
                else if (i >= secondmostTimes) {
                    thirdmostTimes = secondmostTimes;
                    secondmostTimes = i;
                }
                else if (i >= thirdmostTimes) {
                    thirdmostTimes = i;
                }
            }
            System.out.println(uniqueRentalHistory.get(rentalTimes.indexOf(mostTimes)));
            if (uniqueRentalHistory.size() == 2) {
                if (mostTimes == secondmostTimes) {
                    System.out.println(uniqueRentalHistory.get(indexOfAll(rentalTimes, mostTimes).get(1)));
                }
                else {
                    System.out.println(uniqueRentalHistory.get(rentalTimes.indexOf(secondmostTimes)));
                }
            }
            else if (uniqueRentalHistory.size() >= 3) {
                if ((mostTimes == secondmostTimes) && (mostTimes == thirdmostTimes)) {
                   System.out.println(uniqueRentalHistory.get(indexOfAll(rentalTimes, mostTimes).get(1)));
                   System.out.println(uniqueRentalHistory.get(indexOfAll(rentalTimes, mostTimes).get(2)));
                }
                else if (mostTimes == secondmostTimes) {
                    System.out.println(uniqueRentalHistory.get(indexOfAll(rentalTimes, mostTimes).get(1)));
                    System.out.println(uniqueRentalHistory.get(rentalTimes.indexOf(thirdmostTimes)));
                }
                else if (secondmostTimes == thirdmostTimes) {
                    System.out.println(uniqueRentalHistory.get(rentalTimes.indexOf(secondmostTimes)));
                    System.out.println(uniqueRentalHistory.get(indexOfAll(rentalTimes, secondmostTimes).get(1)));
                }
                else {
                    System.out.println(uniqueRentalHistory.get(rentalTimes.indexOf(secondmostTimes)));
                    System.out.println(uniqueRentalHistory.get(rentalTimes.indexOf(thirdmostTimes)));
                }
            }
        }
    }
    
    public void topupAcc(int amount) {
        System.out.println(name + "'s balance was: $" + balance);
        balance += amount;
        System.out.println(name + "'s current balance is: $" + balance);
    }
    
    public void listCurrentlyRentedGames() {
        for (Game game: currentlyRented) {
            System.out.println(game);
        }
    }
    
    public void listRentingHistory() {
        for (Game game: rentingHistory) {
            System.out.println(game);
        }
    }
    
    public void rentGame(Game game, int price) {
        currentlyRented.add(game);
        rentingHistory.add(game);
        balance -= price;
    }
    
    public void returnGame(Game game) {
        currentlyRented.remove(game);
    }
    
    public void returnGamePrintln() {
        System.out.println(name + " has the following games:");
        System.out.println("Games currently rented by " + name + ":");
    }
    
    public boolean hasType(int ID) {
        return this.ID == ID;
    }
    
    public int getBalance() {
        return balance;
    }
    
    @Override
    public String toString() {
        return ID + "\t" + name + "\t$ " + balance;
    }
    
    private ArrayList<Integer> indexOfAll(ArrayList<Integer> rentalTimes, int times) {
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        for (int i = 0; i < rentalTimes.size(); i++) {
            if (rentalTimes.get(i) == times) {
                indexList.add(i);
            }
        }
        return indexList;
    }


    


     
    
    
}
