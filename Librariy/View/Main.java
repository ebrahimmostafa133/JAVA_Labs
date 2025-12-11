package View;

import java.util.ArrayList;
import Controller.Menu;
//import Model.Book;
import Model.Clients;
import Model.LibraryItem;
//import Model.Magazine;

public class Main {
    public static void main(String[] args) {
        // Initialize the collections
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();
        ArrayList<Clients> clientList = new ArrayList<>();

        // Create initial instances (Demonstration for requirement 6)

        // Library Items
        // Book book1 = new Book();
        // book1.setId(101);
        // book1.setTitle("The OOP Principles");
        // libraryItems.add(book1);

        // Magazine mag1 = new Magazine();
        // mag1.setId(201);
        // mag1.setTitle("Java Generics Monthly");
        // libraryItems.add(mag1);

        // // Clients
        // Clients client1 = new Clients(1, "Alice Smith", "alice.s@example.com");
        // Clients client2 = new Clients(2, "Bob Johnson", "bob.j@example.com");
        // clientList.add(client1);
        // clientList.add(client2);
        
        // Pass the collections to the Menu (and thus to Handlers)
        Menu menu = new Menu(libraryItems, clientList);
        
        // Start the application
        menu.showMainMenu();
    }
}