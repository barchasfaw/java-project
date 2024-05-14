package storeManagmentSystem;

public class Items {
	
int id;
    
    String name;
    
//    double price;
    
    String addedDate;
    
    int quantity;
    
    public Items() {
    }

    public Items(int id, String name,   int quantity) {
        this.id = id;
        this.name = name;
        
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  

  

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
