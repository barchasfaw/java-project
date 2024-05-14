package storeManagmentSystem;

public class Client extends User {
	String role = "Client";
    
   
    public Client(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public String getRole() {
        return role;
    }

}
