package Model;

public abstract class LibraryItem implements ILibraryEntity {
    protected int id;
    protected String title;
    protected int stock;
    protected int availableCopies;

    abstract public void getDetails();
    abstract public String getTitle();
    abstract public void setTitle(String title);
    abstract public int getId();
    abstract public void setId(int id);
    abstract public int getStock();
    abstract public void setStock(int stock);
    abstract public int getAvailableCopies();
    abstract public void setAvailableCopies(int availableCopies);
    
    @Override
    public void create() {}
    @Override
    public void read() { getDetails(); }
    @Override
    public void update(String... params) {}
    @Override
    public void delete() {}
}