package Model;

import java.util.ArrayList;
import java.util.List;

public class Clients implements ILibraryEntity {
    private int id;
    private String name;
    private String email;
    // Requirement 1: Collection of borrowed items
    private List<LibraryItem> borrowedItems; 

    public Clients(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();
    }
    
    // Getter for borrowed items
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
    
    // Implementation of read method from ILibraryEntity
    @Override
    public void getDetails() {
        System.out.println("Client ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Borrowed Items Count: " + borrowedItems.size());
        if (!borrowedItems.isEmpty()) {
            System.out.println("--- Borrowed Titles ---");
            // Requirement 3: Use Stream to print borrowed titles
            borrowedItems.stream()
                         .map(LibraryItem::getTitle)
                         .forEach(title -> System.out.println(" - " + title));
        }
    }
    
    // Standard getters and setters (setId, setName, setEmail, etc.)
    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    // Default implementation for ILibraryEntity methods
    @Override
    public void create() { /* Implementation delegated to ClientsHandler */ }
    @Override
    public void read() { getDetails(); }
    @Override
    public void update(String... params) { /* Implementation delegated to ClientsHandler */ }
    @Override
    public void delete() { /* Implementation delegated to ClientsHandler */ }
}