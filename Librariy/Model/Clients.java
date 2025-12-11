package Model;

public class Clients {
    private int id;
    private String name;
    private String email;
    public void setId(int id){
        this.id=id;
    }
    public Clients(int id,String name,String email){
        this.id=id;
        this.name=name;
        this.email=email;
    };
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public void getClientDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }

    
}