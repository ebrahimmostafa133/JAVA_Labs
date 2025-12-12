package Model;

public interface ILibraryEntity {

    void getDetails();

    void create(); 
    void read();
    void update(String... params);
    void delete();

}