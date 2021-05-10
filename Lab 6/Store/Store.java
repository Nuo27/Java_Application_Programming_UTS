import java.util.*;

public class Store {
    private CashRegister cashRegister;
    private LinkedList<Product> products = new LinkedList<Product>();

    public Store() {
        // Insert 6 lines of code to initialise the fields.
        cashRegister = new CashRegister();
        products.add(new Product("Whiteboard Marker", 85, 1.50));
        products.add(new Product("Whiteboard Eraser", 45, 5.00));
        products.add(new Product("Black Pen", 100, 1.50));
        products.add(new Product("Red Pen", 100, 1.50));
        products.add(new Product("Blue Pen", 100, 1.50));  
    }
    
    public static void main(String[] args) {
        new Store().use();
    }
    
    public void use(){
        char choice;
        while((choice = readChoice()) != 'x'){
            switch(choice){
                case 's': sell(); break; 
                case 'r': restock(); break;
                case 'v': viewStock(); break;
                case 'c': viewCash(); break;
                case 'p': pruneProducts(); break;  
                default: help(); break;
            }
        }     
        System.out.println("Done");
    }

    private char readChoice() {
        System.out.print("Choice (s/r/v/c/p/x): ");
        return In.nextChar();
    }

    private void sell() {
//        String inputName = readName();
//        for(Product product: products){
//            if(product.getName().equals(inputName)){
//                System.out.println("Selling " + product.getName());
//                int inputNumber = readNumber();
//                if(product.has(inputNumber)){
//                    double money = product.sell(inputNumber);
//                    cashRegister.add(money);
//                } else{
//                    System.out.println("Not enough stock");
//                } 
//            }
//        }

        String inputName = readName();
        Product product = product(inputName.toLowerCase());
        if(product != null){
            System.out.println("Selling " + product.getName());
            int inputNumber = readNumber();
            if(product.has(inputNumber)){
                cashRegister.add(product.sell(inputNumber));
            }else{
                System.out.println("Not enough stock");
            }
        }else if(products(inputName).size()>1){
            System.out.println("Multiple products match:");
            for(Product prod: products(inputName)){
                System.out.println(prod.toString());
            }
        }else{
            System.out.println("No such product");
        }  
    }
    
    private Product product(String name){
        for(Product product: products){
            if(product.getName().toLowerCase().equals(name)){
                return product;
            }
        }
        return null;
    }
    
    private LinkedList<Product> products(String partialName){
    	LinkedList<Product> matches = new LinkedList<Product>();
    	//System.out.println("Multiple products match:");
            for(Product prod: products){
                if(prod.getName().toLowerCase().contains(partialName.toLowerCase())){
                        matches.add(prod);
                }
            }
            return matches;	
    }

    private void restock() {
        String inputName = readName();
        int inputNumber;
        Product product = product(inputName.toLowerCase());
        if(product != null){
            System.out.println("Restocking " + product.getName());
            inputNumber = readNumber();
            //if(product.has(inputNumber)){
                product.restock(inputNumber);
            //}
    	}else if(products(inputName).size()>1){
            for(Product prod: products(inputName)){
                System.out.println("Restocking " + prod.getName());
                inputNumber = readNumber();
                prod.restock(inputNumber);
            }
        }else{
            System.out.println("Adding new product");
            int newNumber = readNumber();
            double newPrice = readPrice();
            products.add(new Product(inputName, newNumber, newPrice));
    	}
        
//        for(Product product: products){
//            if(product.getName().equals(inputName)){
//                System.out.println("Restocking " + product.getName());
//                int inputNumber = readNumber();
//                product.restock(inputNumber);
//            }
//        }
    }
    
    private void viewStock() {
        for(Product product: products){
            System.out.println(product.toString());
        }
    }

    private void viewCash() {
        System.out.println(cashRegister.toString());
    }

    private void pruneProducts() {
        LinkedList<Product> pruneProducts = pruneProducts(products);
        products.removeAll(pruneProducts);
    }
    
    private LinkedList<Product> pruneProducts(LinkedList<Product> products){
        LinkedList<Product> matches = new LinkedList<Product>();
        for(Product prod: products){
            if(prod.isEmpty()){
                matches.add(prod);
            }	
        }
        return matches;
    }
   
    private String readName() {
        System.out.print("Name: ");
        return In.nextLine();
    }

    private double readPrice() {
        System.out.print("Price: $");
        return In.nextDouble();
    }

    private int readNumber() {
        System.out.print("Number: ");
        return In.nextInt();
    }

    private void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("p = prune products");
        System.out.println("x = exit");
    }
}
