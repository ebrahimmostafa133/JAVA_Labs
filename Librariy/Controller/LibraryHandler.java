package Controller;
import java.util.ArrayList;
import Model.LibraryItem;

public class LibraryHandler {
    private ArrayList<LibraryItem> Items;
    public LibraryHandler(ArrayList<LibraryItem> items) {
        this.Items = items;
    }


    // add function 
    // use generics and wildcards to allow adding and retrieving
    //  items of any subclass of LibraryItem
    public <T extends LibraryItem> void addItem(T item){
        this.Items.add(item);
    }

    // retriev function 
    public LibraryItem getItem(int index) {
        return Items.get(index);
    }

    // display function
    public void displayItem(){
        for(LibraryItem item:Items){
            item.ItemDetails();
        }
    }

    public void updateItem(int index,String title){
        LibraryItem item =Items.get(index);
        item.setTitle(title);
    }

    public void removeItem(int index){
        Items.remove(index);
    }
    public int getItemCount() {
        return Items.size();
    }

}
