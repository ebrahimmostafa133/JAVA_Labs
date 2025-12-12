package View;

import java.util.ArrayList;
import java.util.List;
import Controller.Menu;
import Model.Book;
import Model.Clients;
import Model.LibraryItem;
import Model.Magazine;
import Utilities.IDGenerator;

public class Main {
    public static void main(String[] args) {
        // Initialize the collections
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();
        ArrayList<Clients> clientList = new ArrayList<>();
        
        Book book1 = new Book(IDGenerator.getNextItemId(), "Clean Code", 5);
        Magazine mag1 = new Magazine(IDGenerator.getNextItemId(), "Tech Review Quarterly", 2);
        Book book2 = new Book(IDGenerator.getNextItemId(), "The Great Gatsby", 1);
        
        libraryItems.add(book1);
        libraryItems.add(mag1);
        libraryItems.add(book2);

        Clients client1 = new Clients(IDGenerator.getNextClientId(), "Alice Smith", "alice.s@example.com");
        Clients client2 = new Clients(IDGenerator.getNextClientId(), "Bob Johnson", "bob.j@example.com");
        
        clientList.add(client1);
        clientList.add(client2);
        
        Menu menu = new Menu(libraryItems, clientList);
        
        // Start the application
        menu.showMainMenu();
    }
}