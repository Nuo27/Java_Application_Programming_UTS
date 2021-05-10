import java.util.ArrayList;
import java.util.List;

public class Kiosk {
	private Catalogue catalogue; 
	private List<Customer> customers;
	
		// write your solution here
    private List<Game> games;
	public Kiosk(){
        catalogue = new Catalogue(this);
        customers = new ArrayList<Customer>();
        customers.add(new Customer(101, "Jaime", 10));
        customers.add(new Customer(102, "Luke", 10));
        customers.add(new Customer(103, "William", 1));
    }
    public static void main(String[] args){
         new Kiosk().use(); 
        

    }
   
//read Customer info here.
//------------------------------------------------
    private int readCustomerID() {
        System.out.print("Enter a customer ID: ");
        return In.nextInt();
    }
    
    private int readNewCustomerID() {
        System.out.print("Enter a new ID: ");
        return In.nextInt();
    }
    
    private int readValidCustomerID() {
        System.out.print("Enter a valid customer ID: ");
        return In.nextInt();
    }
    
    private String readCustomerName() {
        System.out.print("Enter the customer's name: ");
        return In.nextLine();
    }
	private int readTopUpAmount(){
        System.out.print("Enter the top-up amount:");
        return In.nextInt();
    }
    
    private int readCustomerBalance() {
        System.out.print("Enter the customer's initial balance: ");
        return In.nextInt();
    }
//----------------------------------------------------------
//read games' info here:
    private String readGameTitle() {
        System.out.print("Enter the title of the game: ");
        return In.nextLine();
    }
    
    private int readGameYear() {
        System.out.print("Enter the year: ");
        return In.nextInt();
    }
    
    private String readGameGenre() {
        System.out.print("Enter the genre: ");
        return In.nextLine();
    }
    
    private String readlistGameGenre() {
        System.out.print("Enter a genre: ");
        return In.nextLine();
    }
    
    private int readGamePrice() {
        System.out.print("Enter price: ");
        return In.nextInt();
    }
    
    private String readRentGame() {
        System.out.print("Enter the title of the game you wish to rent: ");
        return In.nextLine();
    }
    
    private String readReturnGame() {
        System.out.print("Enter the title of the game you wish to return: ");
        return In.nextLine();
    }

// mainmenu starts here.
//-----------------------------------------------------------
    private void use(){
        char choice;
        while((choice = readmainChoice()) !='X'){
            switch(choice){
            case '1': explore();break;
            case '2': View();break;
            case '3': Show();break;
            case '4': Topup();break;
            case '5': EnterAdmin();break;
            default: System.out.println("Please enter a number between 1 and 5, or press X to exit.");break;

        }
        } System.out.println("Thank you for using the Game Kiosk, do visit us again.");
    }
    //mainmenu print out:
    public static char readmainChoice(){
        System.out.println("Welcome to the Game Kiosk! Please make a selection from the menu:");
        System.out.println("1. Explore the catalogue.");
        System.out.println("2. View your customer record.");
        System.out.println("3. Show you favourite games.");
        System.out.println("4. Top up account.");
        System.out.println("5. Enter Admin Mode.");
        System.out.println("X. Exit the system.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }
    //explore cata
    private void explore(){
        char choice;
        while((choice = readCataChoice()) !='R'){
            switch(choice){
            case '1': DAGame();break;
            case '2': DAAG();break;
            case '3': DAGenre();break;
            case '4': DGIG();break;
            case '5': DAGBY();break;
            case '6': RentGame();break;
            case '7': returnGame();break;
            default: System.out.println("Please enter a number between 1 and 7 or press R to return to the previous menu.");break;
            }
        }
    }
    //view the rec
    private void View(){
        System.out.println();
        Customer customer = customer(readCustomerID());
        if (customer != null) {
            customer.viewRecord();
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    //show fav games by id
   private void Show(){
        System.out.println();
        Customer customer = customer(readCustomerID());
        if (customer != null) {
            customer.showFavouriteGames();
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    //Topup acc
    private void Topup(){
        System.out.println();
        Customer customer = customer(readCustomerID());
        if (customer != null) {
            int amount = readTopUpAmount();
            System.out.println();
            System.out.println("Transaction complete.");
            customer.topupAcc(amount);
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    //admin menu
    private void EnterAdmin(){
        char choice;
        while((choice = adminChoice()) !='R'){
            switch(choice){
            case '1': listCus();break;
            case '2': AddCus();break;
            case '3': RemoveCus();break;
            case '4': listGame();break;
            case '5': AddGame();break;
            case '6': RemoveGame();break;
            default: System.out.println("Please enter a number between 1 and 6 or press R to return to the previous menu."); break;
            }
        }
    }
//mainmenu finish here.
//--------------------------------------------------------------------------   
    
    
        
//catamenu starts here.
//---------------------------------------------------------------------------
    //cata print output:
    public static char readCataChoice(){
        System.out.println("Welcome to the Catalogue! Please make a selection from the menu:");
        System.out.println("1. Display all games.");
        System.out.println("2. Display all available games.");
        System.out.println("3. Display all genres.");
        System.out.println("4. Display games in a genre.");
        System.out.println("5. Display all games by year.");
        System.out.println("6. Rent a game.");
        System.out.println("7. Return a game.");
        System.out.println("R. Return to previous menu.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }
    //display all games:
    private void DAGame(){
        System.out.println();
        System.out.println("The Kiosk has the following games:");
        catalogue.listAvailableGames();
        catalogue.listRentedGames();
        System.out.println();
    }
    //display all available games
    private void DAAG(){
        System.out.println();
        System.out.println("The following games are available:");
        catalogue.listAvailableGames();
        System.out.println();
    }
    //display all genre:
    private void DAGenre(){
        System.out.println();
        System.out.println("The Kiosk has games in the following genres:");
        catalogue.listGenres();
        System.out.println();
    }
    //Display games in a genre.
    private void DGIG(){
        System.out.println();
        String genre = readlistGameGenre();
        System.out.println("The kiosk has the following games in that genre:");
        catalogue.listGamesByGenre(genre);
        System.out.println();
    }
    //display all games by year
    private void DAGBY(){
        System.out.println();
        int year = readGameYear();
        System.out.println("The kiosk has the following games by that year:");
        catalogue.listGamesByYear(year);
        System.out.println();
    }
    //rent game
    private void RentGame(){
        System.out.println();
        Customer customer = customer(readValidCustomerID());
        if (customer != null) {
            Game game = catalogue.game(readRentGame());
            if (game != null && catalogue.isGameAvailable(game)) {
                int price = game.getPrice();
                if (customer.getBalance() >= price) {
                    System.out.println("Game rented.");
                    customer.rentGame(game, price);
                    catalogue.rentGame(game);
                }
                else {
                    System.out.println("You don't have sufficient funds to rent this game.");
                }
            }
            else {
                System.out.println("That game is not available or doesn't exist.");
            }
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    //return game
    private void returnGame() {
        System.out.println();
        Customer customer = customer(readValidCustomerID());
        if (customer != null) {
            customer.returnGamePrintln();
            customer.listCurrentlyRentedGames();
            Game game = catalogue.game(readReturnGame());
            if (game != null) {
                game.returnGamePrintln();
                customer.returnGame(game);
                catalogue.returnGame(game);
            }
            else {
                System.out.println("No such game found.");
            }
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    //return to previous menu
//catamenu finishes here
//----------------------------------------------------------------
    
    
//adminmenu starts here
//-----------------------------------------------------------------

    public char adminChoice(){
        System.out.println("Welcome to the administration menu:");
        System.out.println("1. List all customers.");
        System.out.println("2. Add a customer.");
        System.out.println("3. Remove a customer.");
        System.out.println("4. List all games.");
        System.out.println("5. Add a game to the catalogue.");
        System.out.println("6. Remove a game from the catalogue.");
        System.out.println("R. Return to the previous menu.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }
    //list all customers
    private void listCus(){
        System.out.println();
        System.out.println("The Kiosk has the following customers:");
        for (Customer customer: customers) {
            System.out.println(customer);
        }
        System.out.println();
    }
    private Customer customer(int ID) {
        for (Customer customer: customers) {
            if (customer.hasType(ID)) {
                return customer;
            }
        }
        return null;
    }
    //add customer
    private void AddCus(){
        System.out.println();
        System.out.println("Adding a new customer.");
        customers.add(new Customer(readNewCustomerID(), readCustomerName(), readCustomerBalance()));
        System.out.println("Customer added.");
        System.out.println();
    }
    private int reenterid() {
        System.out.println("That customer already exists, please enter a new ID: ");
            return In.nextInt();
    }
    //remove customer
    private void RemoveCus(){
        System.out.println();
        System.out.println("Removing a customer.");
        Customer customer = customer(readCustomerID());
        if (customer != null) {
            System.out.println("Customer removed.");
            customers.remove(customer);
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();

    }
    
    
    //list all game
    private void listGame(){
        System.out.println();
        System.out.println("The Kiosk has the following games:");
        catalogue.listAvailableGames();
        catalogue.listRentedGames();
        System.out.println();
       
    }
     
        
        

    //add game to cata
    private void AddGame(){
        System.out.println();
        System.out.println("Adding a new game.");
        String title = readGameTitle();
        int year = readGameYear();
        String genre = readGameGenre();
        int price = readGamePrice();
        if (catalogue.hasGame(title, year, genre)) {
            System.out.println("The game is already in the catalogue.");
        }
        else {
            catalogue.addGame(title, year, genre, price);
            System.out.println("Added "+title+" to catalogue.");
            System.out.println();
        }
    }
    //remove game from cata
    private void RemoveGame(){
        System.out.println();
        System.out.println("Removing a game.");
        String title = readGameTitle();
        int year = readGameYear();
        Game game = catalogue.game2(title, year);
        if (game != null) {
            System.out.println(game + " removed from catalogue.");
            catalogue.removeGame(game);
        }
        else {
            System.out.println("No such game found.");
        }
        System.out.println();
    }
    //return to previous menu
//adminmenu finishes here
//-------------------------------------------------------------------



}
