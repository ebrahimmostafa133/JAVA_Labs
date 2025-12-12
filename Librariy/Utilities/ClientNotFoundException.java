package Utilities;

//Custom Exception (for client)
public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(String message) {
        super(message);
    }
}