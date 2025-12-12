package Controller;

import java.util.List;
import java.util.Optional;
import Model.Clients;
import Utilities.ClientNotFoundException;

public class ClientsHandler {
    private List<Clients> clients;

    public ClientsHandler(List<Clients> clients) {
        this.clients = clients;
    }

    public Optional<Clients> getClientById(int id) {
        return clients.stream()
                      .filter(client -> client.getId() == id)
                      .findFirst();
    }
    
    public void addClient(Clients c){
        clients.add(c);
    }

    public Clients getClient(int index) throws ClientNotFoundException {
        if (index < 0 || index >= clients.size()) {
            throw new ClientNotFoundException("Client not found at index: " + index);
        }
        return clients.get(index);
    }
    
    public void updateClient(int index, String name, String email) throws ClientNotFoundException {
        Clients c = getClient(index);
        c.setName(name);
        c.setEmail(email);
    }

    public void deleteClient(int index) throws ClientNotFoundException {
        Clients c = getClient(index);
        if (!c.getBorrowedItems().isEmpty()) {
            System.out.println("Cannot delete client " + c.getName() + ". They still have " + c.getBorrowedItems().size() + " items borrowed.");
            return;
        }
        clients.remove(index);
    }
  
    public void displayClients() {
        System.out.println("\n--- All Clients ---");
        clients.stream().forEach(Clients::getDetails);
        System.out.println("-------------------");
    }
}