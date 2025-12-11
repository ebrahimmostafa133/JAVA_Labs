package Model;

public class Book extends LibraryItem {
    private int id;
    private String title;
    @Override
    public void ItemDetails(){
        System.out.println("Book ID: "+id +"\n"+ "Book Title: "+ title);
    }
    public void setId(int id){
        this.id=id;
    }
    @Override
    public void setTitle(String title){
        this.title=title;
    }
    @Override
    public int getId(){
        return id;
    }
    @Override
    public String getTitle(){
        return title;
    }
    
}
