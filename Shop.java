package storeManagmentSystem;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import storeManagmentSystem.Admin;
import storeManagmentSystem.Client;
import storeManagmentSystem.Items;
import storeManagmentSystem.Sales;
import storeManagmentSystem.Shop;

public class Shop {
	 int id;
	    
	    String name;
	    
	    String location;
	    
	    private final Map<Integer, Items> groceryItems = new HashMap<Integer, Items>();
	    

	    
	    private final Map<String, Admin> admins = new HashMap<String, Admin>();
	    
	    private static Shop shop = new Shop();
	    
	    private final Map<String, Client> clients = new HashMap<String, Client>();
	    private final Map<String, Client_e> clients_e = new HashMap<String, Client_e>();
	    
	    
	    
	    public Shop() {}
	    
	    public static Shop getShop() {
	        return shop;
	    }
	    
	    public static void setShop(Shop sh) {
	        shop = null;
	        shop = sh;
	    }
	    
	    public void addClient(Client c) {
	        clients.put(c.email, c);
	    }
	    public void addClient_e(Client_e c) {
	        clients_e.put(c.email, c);
	    }
	    
	
	    public void addItem(Items i) {
	        groceryItems.put(i.id, i);
	    }
	    
	    public void addAdmin(Admin a) {
	        admins.put(a.email, a);
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

	   
	    
	    public Items getItem(int id) {
	        return groceryItems.get(id);
	    }

	    public Collection<Items> getGroceryItems() {
	        return groceryItems.values();
	    }
	    


	    public Collection<Client> getClients() {
	        return clients.values();
	    }
	    public Collection<Client_e> getClients_e() {
	        return clients_e.values();
	    }
	    public Client getClient(String email)
	    {
	    	
	    	return clients.get(email);
	    }

	    public Collection<Admin> getAdmins() {
	        return admins.values();
	    }
	    
	    public Admin getAdmin(String email) {
	        return admins.get(email);
	    }

	   
	    
	   
	    
	    

}
