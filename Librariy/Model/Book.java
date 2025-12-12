package Model;
// Book.java
public class Book extends LibraryItem {
    
    public Book(int id, String title, int stock) {
        this.id = id;
        this.title = title;
        this.stock = stock;
        this.availableCopies = stock;
    }
    
    @Override
    public void getDetails(){
        System.out.println("Type: Book | ID: "+id +" | Title: "+ title +" | Total Stock: " + stock + " | Available: " + availableCopies);
    }

    // Standard getters and setters for id, title, stock, availableCopies
    @Override
    public int getStock() { return stock; }
    @Override
    public void setStock(int stock) { this.stock = stock; }
    @Override
    public int getAvailableCopies() { return availableCopies; }
    @Override
    public void setAvailableCopies(int availableCopies) { this.availableCopies = availableCopies; }
    // ... (rest of the overridden methods like setId, setTitle, etc.)
    @Override
    public int getId(){ return id; }
    @Override
    public void setId(int id){ this.id = id; }
    @Override
    public String getTitle(){ return title; }
    @Override
    public void setTitle(String title){ this.title = title; }
}
