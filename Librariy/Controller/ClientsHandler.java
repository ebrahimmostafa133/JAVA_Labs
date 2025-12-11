package Controller;

import java.util.ArrayList;

import Model.Clients;

public class ClientsHandler {
    private ArrayList<Clients> clients;

    public ClientsHandler(ArrayList<Clients> clients) {
        this.clients = clients;
    }


    public void addClient(Clients c){
        clients.add(c);
    }

    public Clients getClient(int index){
        return clients.get(index);
    }

    public void updateClient(int index, String name, String email){
        Clients c= clients.get(index);
        c.setName(name);
        c.setEmail(email);
    }

    public void deleteClient(int index){
        clients.remove(index);
    }
  
    public void displayClients() {
        for (Clients c : clients) {
            c.getClientDetails();
        }
    }

}
