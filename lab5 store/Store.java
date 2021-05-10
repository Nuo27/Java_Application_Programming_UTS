/**
 * The store has and sells one product: Sticky tape.
 *
 * You can sell and restock a product, view stock and view cash.
 */
public class Store {
    // insert main method here
    // insert 2 fields here
    // insert 1 constructor here
    
    private Product product;
    private CashRegister cashRegister;
    
    public Store(){
       product = new Product("Sticky tape", 200, 2.99);
       cashRegister = new CashRegister();
    }
    
    public static void main(String[] args) {
        new Store().use();
    }

    public void use() {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
            case 's': sell(); break;
            case 'r': restock(); break;
            case 'v': viewStock(); break;
            case 'c': viewCash(); break;
            default: help(); break;
            }
        }
    }
    
    private char readChoice() {
        System.out.print("Choice (s/r/v/c/x): ");
        return In.nextChar();
    }

    private void sell() {
        System.out.print("Number: ");
        int insertCoolVariableName = In.nextInt();
        if(product.has(insertCoolVariableName)){
            cashRegister.add(product.sell(insertCoolVariableName));
        } else{
            System.out.println("Not enough stock");
        }
    }

    private void restock() {
        System.out.print("Number: ");
        int insertAnotherCoolName = In.nextInt();
        product.restock(insertAnotherCoolName);
    }

    private void viewStock() {
        System.out.println(product.toString());
    }

    private void viewCash() {
        System.out.println(cashRegister.toString());
    }
    
    private void exit(){
        
    }

    private void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("x = exit");
    }
}
