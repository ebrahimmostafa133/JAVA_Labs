package Model;

public interface ILibraryEntity {

    void getDetails();
    
    // Simplistic view of CRUD methods required by the prompt
    // The actual execution logic remains in the Handler classes
    void create(); 
    void read();
    void update(String... params);
    void delete();

}