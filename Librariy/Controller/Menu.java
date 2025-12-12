package Controller;

import java.util.InputMismatchException;
import java.util.List;
import Model.Book;
import Model.Clients;
import Model.LibraryItem;
import Model.Magazine;
// FIX 1: Import all necessary exceptions
import Utilities.ItemNotFoundException; 
import Utilities.ClientNotFoundException;
import Utilities.IDGenerator;

// BONUS 6: User-Friendly Menu
public class Menu {
    private LibraryHandler library;
    private ClientsHandler clients;
    private java.util.Scanner scanner;

    public Menu(List<LibraryItem> libraryItems, List<Clients> clientList) {
        library = new LibraryHandler(libraryItems);
        clients = new ClientsHandler(clientList);
        scanner = new java.util.Scanner(System.in);
    }

    // --- Main Menu ---
    public void showMainMenu() {
        int choice = 0;
        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Manage Library Items");
            System.out.println("2. Manage Clients");
            System.out.println("3. Borrow/Return Items");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: showLibraryMenu(); break;
                    case 2: showClientMenu(); break;
                    case 3: showBorrowMenu(); break;
                    case 4: System.out.println("Exiting. Thank you!"); break;
                    default: System.out.println("Invalid choice. Please select 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 4);
    }
    
    // --- Library Item Menu (CRUD) ---
    private void showLibraryMenu() {
        int choice = 0;
        do {
            System.out.println("\n--- Library Item Menu (CRUD) ---");
            System.out.println("1. Add Item");
            System.out.println("2. Display Item by Index");
            System.out.println("3. Update Item Title by Index");
            System.out.println("4. Delete Item by Index");
            System.out.println("5. Display All Items");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter choice: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1: addLibraryItem(); break;
                    case 2: retrieveLibraryItem(); break;
                    case 3: updateLibraryItem(); break;
                    case 4: deleteLibraryItem(); break;
                    case 5: library.displayItem(); break;
                    case 6: System.out.println("Returning..."); break;
                    default: System.out.println("Invalid choice. Please select 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 6);
    }
    
    private void addLibraryItem() {
        System.out.println("\nSelect item type: 1. Book | 2. Magazine");
        System.out.print("Enter type choice: ");

        try {
            int typeChoice = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter stock quantity: ");
            int stock = scanner.nextInt();
            scanner.nextLine();
            
            if (stock <= 0) {
                 System.out.println("Stock must be greater than zero.");
                 return;
            }
            
            int newId = IDGenerator.getNextItemId();
            LibraryItem item = null;
            
            if (typeChoice == 1) {
                item = new Book(newId, title, stock);
            } else if (typeChoice == 2) {
                item = new Magazine(newId, title, stock);
            } else {
                System.out.println("Invalid item type. Item not added.");
                return;
            }

            if (item != null) {
                library.addItem(item);
                System.out.println(item.getClass().getSimpleName() + " added successfully! ID: " + item.getId());
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input for stock. Item not added.");
            scanner.nextLine();
        }
    }

    private void retrieveLibraryItem() {
        System.out.print("Enter index of item to retrieve: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();
            library.getItem(index).getDetails();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void updateLibraryItem() {
        System.out.print("Enter index of item to update: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new title: ");
            String title = scanner.nextLine();
            library.updateItem(index, title);
            System.out.println("Item updated successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteLibraryItem() {
        System.out.print("Enter index of item to delete: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();
            library.removeItem(index);
            System.out.println("Item deleted successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // --- Client Menu (CRUD) ---
    private void showClientMenu() {
        int choice = 0;
        do {
            System.out.println("\n--- Client Menu (CRUD) ---");
            System.out.println("1. Add Client");
            System.out.println("2. Display Client by Index");
            System.out.println("3. Update Client by Index");
            System.out.println("4. Delete Client by Index");
            System.out.println("5. Display All Clients");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter choice: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: addClient(); break;
                    case 2: retrieveClient(); break;
                    case 3: updateClient(); break;
                    case 4: deleteClient(); break;
                    case 5: clients.displayClients(); break;
                    case 6: System.out.println("Returning..."); break;
                    default: System.out.println("Invalid choice. Please select 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 6);
    }
    
    private void addClient() {
        try {
            System.out.print("Enter client name: ");
            String name = scanner.nextLine();
            System.out.print("Enter client email: ");
            String email = scanner.nextLine();
            
            int newId = IDGenerator.getNextClientId();
            Clients client = new Clients(newId, name, email);
            clients.addClient(client);
            System.out.println("Client added successfully! ID: " + client.getId());
        } catch (Exception e) {
            System.out.println("Error adding client: " + e.getMessage());
        }
    }

    private void retrieveClient() {
        System.out.print("Enter index of client to retrieve: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();
            clients.getClient(index).getDetails();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        } catch (ClientNotFoundException e) {
            // FIX 4: Correct exception handling for ClientNotFoundException
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateClient() {
        System.out.print("Enter index of client to update: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            
            clients.updateClient(index, name, email);
            System.out.println("Client updated successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        } catch (ClientNotFoundException e) {
            // FIX 4: Correct exception handling
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteClient() {
        System.out.print("Enter index of client to delete: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();
            clients.deleteClient(index);
            System.out.println("Client deletion process complete.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        } catch (ClientNotFoundException e) {
            // FIX 4: Correct exception handling
            System.out.println("Error: " + e.getMessage());
        }
    }

    // --- Borrow/Return Menu (Feature 2) ---
    private void showBorrowMenu() {
        int choice = 0;
        do {
            System.out.println("\n--- Borrow/Return Menu ---");
            System.out.println("1. Borrow Item (by ID)");
            System.out.println("2. Return Item (by ID)");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: borrowItem(); break;
                    case 2: returnItem(); break;
                    case 3: System.out.println("Returning..."); break;
                    default: System.out.println("Invalid choice. Please select 1-3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 3);
    }
    
    private void borrowItem() {
        System.out.print("Enter Client ID: ");
        int clientId = getIntInput();
        if (clientId == -1) return;

        System.out.print("Enter Item ID to borrow: ");
        int itemId = getIntInput();
        if (itemId == -1) return;

        try {
            Clients client = clients.getClientById(clientId)
                                    // FIX 2: Correct lambda syntax for orElseThrow
                                    .orElseThrow(() -> new ClientNotFoundException("Client ID " + clientId + " not found."));
            
            library.borrowItem(itemId, client);
        } catch (ClientNotFoundException | ItemNotFoundException e) {
            // FIX 3: Catch both relevant custom exceptions
            System.out.println("Borrow Failed: " + e.getMessage());
        }
    }

    private void returnItem() {
        System.out.print("Enter Client ID: ");
        int clientId = getIntInput();
        if (clientId == -1) return;

        System.out.print("Enter Item ID to return: ");
        int itemId = getIntInput();
        if (itemId == -1) return;

        try {
            Clients client = clients.getClientById(clientId)
                                    // FIX 2: Correct lambda syntax for orElseThrow
                                    .orElseThrow(() -> new ClientNotFoundException("Client ID " + clientId + " not found."));
            
            library.returnItem(itemId, client);
        } catch (ClientNotFoundException | ItemNotFoundException e) {
            // FIX 3: Catch both relevant custom exceptions
            System.out.println("Return Failed: " + e.getMessage());
        }
    }
    
    private int getIntInput() {
        try {
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            return -1;
        }
    }
}