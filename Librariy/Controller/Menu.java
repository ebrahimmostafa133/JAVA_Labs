package Controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Model.Book;
import Model.Clients;
import Model.LibraryItem;
import Model.Magazine;
import utilities.ItemNotFoundException; 

public class Menu {
    private LibraryHandler library;
    private ClientsHandler clients;
    private Scanner scanner;
    // Static counter for item IDs (simplified auto-increment)
    private static int nextItemId = 1;
    private static int nextClientId = 1;


    // Constructor takes lists as parameters
    public Menu(ArrayList<LibraryItem> libraryItems, ArrayList<Clients> clientList) {
        library = new LibraryHandler(libraryItems);
        clients = new ClientsHandler(clientList);
        scanner = new Scanner(System.in);
    }

    // Main menu
    public void showMainMenu() {
        int choice;
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Manage Library Items");
            System.out.println("2. Manage Clients");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        showLibraryMenu();
                        break;
                    case 2:
                        showClientMenu();
                        break;
                    case 3:
                        System.out.println("Exiting Library Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume the invalid input
                choice = 0; // Set choice to 0 to continue the loop
            }

        } while (choice != 3);
    }

    // Library menu
    private void showLibraryMenu() {
        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Retrieve Item Details");
            System.out.println("3. Update Item Title");
            System.out.println("4. Delete Item");
            System.out.println("5. Display All Items");
            System.out.println("6. Back");
            System.out.print("Enter choice: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addLibraryItem();
                        break;
                    case 2:
                        retrieveLibraryItem();
                        break;
                    case 3:
                        updateLibraryItem();
                        break;
                    case 4:
                        deleteLibraryItem();
                        break;
                    case 5:
                        library.displayItem();
                        break;
                    case 6:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 6);
    }

    private void addLibraryItem() {
        System.out.println("\nSelect item type:");
        System.out.println("1. Book");
        System.out.println("2. Magazine");
        System.out.print("Enter item type choice: ");

        try {
            int typeChoice = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter title of the item: ");
            String title = scanner.nextLine();
            
            LibraryItem item = null;
            switch (typeChoice) {
                case 1:
                    Book book = new Book();
                    book.setId(nextItemId++);
                    book.setTitle(title);
                    item = book;
                    break;
                case 2:
                    Magazine magazine = new Magazine();
                    magazine.setId(nextItemId++);
                    magazine.setTitle(title);
                    item = magazine;
                    break;
                default:
                    System.out.println("Invalid item type. Item not added.");
                    return;
            }

            if (item != null) {
                library.addItem(item); // Uses generics T extends LibraryItem
                System.out.println("Item added successfully! ID: " + item.getId());
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Item not added.");
            scanner.nextLine();
        }
    }

    private void retrieveLibraryItem() {
        System.out.print("Enter index of item to retrieve: ");
        int index = -1;
        try {
            index = scanner.nextInt();
            scanner.nextLine();
            
            LibraryItem item = library.getItem(index);
            if (item == null) {
                // If getItem was modified to return null on error, use that.
                // For now, rely on IndexOutOfBoundsException.
                throw new ItemNotFoundException("Item at index " + index + " not found.");
            }
            System.out.println("\n--- Item Details ---");
            item.ItemDetails();
            System.out.println("--------------------");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for the index.");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            // Check if the list is empty or if the index is simply out of bounds
            System.out.println("Error: No item found at index " + index + " (List size: " + library.getItemCount() + ")");
            // Optionally, re-throw as custom exception for consistent error messaging
             try {
                 new ItemNotFoundException("Item not found. Invalid index provided.").trigger();
             } catch (ItemNotFoundException ex) {
                 System.out.println(ex.getMessage());
             }
        } catch (ItemNotFoundException e) {
            // This would be triggered if getItem returned null and we threw it.
            System.out.println(e.getMessage());
        }
    }

    private void updateLibraryItem() {
        System.out.print("Enter index of item to update: ");
        int index = -1;
        try {
            index = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new title: ");
            String title = scanner.nextLine();
            
            library.updateItem(index, title);
            System.out.println("Item updated successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for the index.");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Cannot update. No item found at index " + index + ".");
            // Optional: Use custom exception
             try {
                 new ItemNotFoundException("Item not found for update.").trigger();
             } catch (ItemNotFoundException ex) {
                 System.out.println(ex.getMessage());
             }
        }
    }

    private void deleteLibraryItem() {
        System.out.print("Enter index of item to delete: ");
        int index = -1;
        try {
            index = scanner.nextInt();
            scanner.nextLine();
            library.removeItem(index);
            System.out.println("Item deleted successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for the index.");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Cannot delete. No item found at index " + index + ".");
            // Optional: Use custom exception
             try {
                 new ItemNotFoundException("Item not found for deletion.").trigger();
             } catch (ItemNotFoundException ex) {
                 System.out.println(ex.getMessage());
             }
        }
    }

    // Client menu
    private void showClientMenu() {
        int choice;
        do {
            System.out.println("\n--- Client Menu ---");
            System.out.println("1. Add Client");
            System.out.println("2. Retrieve Client Details");
            System.out.println("3. Update Client Name and Email");
            System.out.println("4. Delete Client");
            System.out.println("5. Display All Clients");
            System.out.println("6. Back");
            System.out.print("Enter choice: ");
            
             try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addClient();
                        break;
                    case 2:
                        retrieveClient();
                        break;
                    case 3:
                        updateClient();
                        break;
                    case 4:
                        deleteClient();
                        break;
                    case 5:
                        clients.displayClients();
                        break;
                    case 6:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
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
            
            // Auto-increment ID
            Clients client = new Clients(nextClientId++, name, email); 
            clients.addClient(client);
            System.out.println("Client added successfully! ID: " + client.getId());
        } catch (Exception e) {
            System.out.println("Error adding client: " + e.getMessage());
        }
    }

    private void retrieveClient() {
        System.out.print("Enter index of client to retrieve: ");
        int index = -1;
        try {
            index = scanner.nextInt();
            scanner.nextLine();
            Clients client = clients.getClient(index);
            System.out.println("\n--- Client Details ---");
            client.getClientDetails();
            System.out.println("----------------------");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for the index.");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: No client found at index " + index + ".");
        }
    }

    private void updateClient() {
        System.out.print("Enter index of client to update: ");
        int index = -1;
        try {
            index = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            
            clients.updateClient(index, name, email);
            System.out.println("Client updated successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for the index.");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Cannot update. No client found at index " + index + ".");
        }
    }

    private void deleteClient() {
        System.out.print("Enter index of client to delete: ");
        int index = -1;
        try {
            index = scanner.nextInt();
            scanner.nextLine();
            clients.deleteClient(index);
            System.out.println("Client deleted successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for the index.");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Cannot delete. No client found at index " + index + ".");
        }
    }
}