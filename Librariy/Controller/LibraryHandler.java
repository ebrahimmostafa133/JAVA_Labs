package Controller;

import java.util.List;
import Model.LibraryItem;
import Model.Clients;
import Utilities.ItemNotFoundException;
import java.util.Optional; 
import java.util.stream.Collectors;

public class LibraryHandler {
    private List<LibraryItem> Items;

    public LibraryHandler(List<LibraryItem> items) {
        this.Items = items;
    }

    // Generics and Wildcards (for adding)
    public <T extends LibraryItem> void addItem(T item){
        this.Items.add(item);
    }
    
    public Optional<LibraryItem> getItemById(int id) {
        return Items.stream()
                    .filter(item -> item.getId() == id)
                    .findFirst();
    }

    public LibraryItem getItem(int index) throws ItemNotFoundException {
        if (index < 0 || index >= Items.size()) {
            throw new ItemNotFoundException("Library Item not found at index: " + index);
        }
        return Items.get(index);
    }

    public void displayItem(){
        System.out.println("\n--- All Library Items ---");
        Items.stream().forEach(LibraryItem::getDetails);
        System.out.println("-------------------------");
    }

    public void updateItem(int index, String title) throws ItemNotFoundException {
        LibraryItem item = getItem(index);
        item.setTitle(title);
    }

    public void removeItem(int index) throws ItemNotFoundException {
        getItem(index); 
        Items.remove(index);
    }

    public void borrowItem(int itemId, Clients client) throws ItemNotFoundException {
        Optional<LibraryItem> itemOpt = getItemById(itemId);

        if (!itemOpt.isPresent()) {
            throw new ItemNotFoundException("Item with ID " + itemId + " not found.");
        }

        LibraryItem item = itemOpt.get();

        if (item.getAvailableCopies() > 0) {
            item.setAvailableCopies(item.getAvailableCopies() - 1);
            client.getBorrowedItems().add(item);
            System.out.println(item.getTitle() + " successfully borrowed by " + client.getName());
        } else {
            System.out.println("Error: " + item.getTitle() + " is currently out of stock.");
        }

    }

    public void returnItem(int itemId, Clients client) throws ItemNotFoundException {
        Optional<LibraryItem> itemOpt = getItemById(itemId);

        if (!itemOpt.isPresent()) {
            throw new ItemNotFoundException("Item with ID " + itemId + " not found in library stock.");
        }
        
        LibraryItem itemToReturn = itemOpt.get();

        boolean removed = client.getBorrowedItems().removeIf(
            item -> item.getId() == itemId
        );

        if (removed) {
            itemToReturn.setAvailableCopies(itemToReturn.getAvailableCopies() + 1);
            System.out.println(itemToReturn.getTitle() + " successfully returned by " + client.getName());
        } else {
            System.out.println("Error: " + client.getName() + " did not borrow the item with ID " + itemId + ".");
        }
    }
}