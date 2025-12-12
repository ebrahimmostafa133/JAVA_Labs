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
    
    // Requirement 3: Use Stream to find item by ID
    public Optional<LibraryItem> getItemById(int id) {
        return Items.stream()
                    .filter(item -> item.getId() == id)
                    .findFirst();
    }

    // Retrieve by index (for legacy CRUD support)
    public LibraryItem getItem(int index) throws ItemNotFoundException {
        if (index < 0 || index >= Items.size()) {
            throw new ItemNotFoundException("Library Item not found at index: " + index);
        }
        return Items.get(index);
    }

    public void displayItem(){
        System.out.println("\n--- All Library Items ---");
        // Requirement 3: Use Stream to display details
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

    // Requirement 2: Borrow/Rent Feature
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

        // boolean alreadyBorrowed = client.getBorrowedItems().stream()
        //                                 .anyMatch(i -> i.getId() == itemId);

        // if (alreadyBorrowed) {
        //     System.out.println("Error: " + client.getName() + " has already borrowed a copy of '" + item.getTitle() + "'.");
        //     return;
        // }
        // // ----------------------------------------------------------------------

        // if (item.getAvailableCopies() > 0) {
        //     item.setAvailableCopies(item.getAvailableCopies() - 1);
        //     client.getBorrowedItems().add(item);
        //     System.out.println(item.getTitle() + " successfully borrowed by " + client.getName());
        // } else {
        //     // Requirement: If the item has borrowed (i.e., availableCopies is 0), 
        //     // no other client can borrow it. (This is already covered here)
        //     System.out.println("Error: '" + item.getTitle() + "' is currently out of stock. Available copies: 0.");
        // }
    }

    // Requirement 2: Return Feature
    public void returnItem(int itemId, Clients client) throws ItemNotFoundException {
        Optional<LibraryItem> itemOpt = getItemById(itemId);

        if (!itemOpt.isPresent()) {
            throw new ItemNotFoundException("Item with ID " + itemId + " not found in library stock.");
        }
        
        LibraryItem itemToReturn = itemOpt.get();

        // Requirement 4: Validation - Check if client actually borrowed this item
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