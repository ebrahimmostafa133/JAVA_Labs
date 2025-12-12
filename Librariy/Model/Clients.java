package Model;

import java.util.ArrayList;
import java.util.List;

public class Clients implements ILibraryEntity {
    private int id;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems; 

    public Clients(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();
    }
    
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
    
    @Override
    public void getDetails() {
        System.out.println("Client ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Borrowed Items Count: " + borrowedItems.size());
        if (!borrowedItems.isEmpty()) {
            System.out.println("--- Borrowed Titles ---");
            borrowedItems.stream()
                         .map(LibraryItem::getTitle)
                         .forEach(title -> System.out.println(" - " + title));
        }
    }
    
    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    @Override
    public void create() {}
    @Override
    public void read() { getDetails(); }
    @Override
    public void update(String... params) {}
    @Override
    public void delete() {}
}