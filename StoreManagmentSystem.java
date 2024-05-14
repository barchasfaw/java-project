package storeManagmentSystem;


import java.util.Collection;
import java.util.Random;
import java.util.Scanner;



public class StoreManagmentSystem {
	static Random idr = new Random();
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		
		Admin admin = new Admin(Math.abs(idr.nextInt()), "e", "e@gmail.com", "e");
		Shop.getShop().addAdmin(admin);
		displayadminLogin();
		 
		 
	}
	
//	print admin menu
	public static void printmainmenu() {
        System.out.println("-------------- welcome Text --------------");
        System.out.println("Welcome To Admin Menu.");
        System.out.println("Please Enter: \n1.Add a customer "
        		+ "\n2.Add Items "
        		+ "\n3. View Clients "
        		+ "\n4.add dept to customer "
        		+ "\n5.View customer with dept  "
        		+ "\n6.to exit the system");
        
        int a = in.nextInt();
        
        switch (a) {
            case 1:
                displayjoincustomer();
                break;
            case 2:
            	additems();
                break;
            case 3:
            	viewusers();
                break;
            case 4:
                displayproducts();
                break;
            case 5:
                e_user();
                break;
            case 6:
                exitSystem();
                break;
            default:
                System.out.println("Unknown Input");
                System.out.println("Please enter again");
                printmainmenu();
                break;
        }
        

    }
	
//	exit
	 public static void exitSystem() {
	        System.out.println("------------ Good bye text -------");
	        System.exit(0);
	    }
	 
//	 customer registration
	    public static void displayjoincustomer() {
	        System.out.println("Hi, welcome to registration page");
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter your name?");
	        String name = in.next();
	        System.out.println("Enter your email?");
	        String email = in.next();
	        System.out.println("Enter your phone number?");
	        String password = in.next();
	        System.out.println("Enter your id");
	        int id = in.nextInt();
	        
	        Client nc = new Client(id, name, email, password);
	        
	       Shop.getShop().addClient(nc);
	        

	        System.out.println("This Name: " + name + " has been registerd...");
	        System.out.println("Enter \n 1.to go back to main menu "
	        		+ "\n 2.to Add another one");
	        int ch = in.nextInt();
	        
	        if (ch == 1) {
	        	
	           printmainmenu();
	            
	        } else if (ch == 2) {
	            displayjoincustomer();
	        } 
	    }
	    
//	  Admin login  
	    public static void displayadminLogin() {
	        System.out.println("please enter email: ");
	        String email = in.next();
	        System.out.println("Enter password: ");
	        String password = in.next();
	        Admin e = Shop.getShop().getAdmin(email);
	        
	        if (e != null && e.password.equals(password)) {
	        	
	        	printmainmenu();
	        	
	           
	        } else {
	            System.out.println("couldn't find your email and acount.");
	            System.out.println("Enter \n1.To retry "
	            		+ "\n2.to exit the system.");
	            int c = in.nextInt();
	            if (c == 1) {
	            	displayadminLogin();
	            } else if (c == 2) {
	                exitSystem();
	            }
	        }
	    }
	 
//	    add objects to customer to register
	    public static void displayproducts() {
	        System.out.println("Enter 1.Choose product to add it to customer 2.To mainu");
	        System.out.println("-----------Items--------------------");
	        System.out.println("Id\t\t\tName\t\t\tQuantitiy");
	        
	        
	        Collection<Items> allitems = Shop.getShop().getGroceryItems();
	        
	        if (allitems.isEmpty()) {
	            System.out.println("No Items yet...");
	        } else {
	            for (Items it : allitems) {
	                System.out.println(it.id + "\t\t\t\t" + it.name + "\t\t\t\t"  + it.quantity);
	            }
	        }
	        
	        int b = in.nextInt();
	        if (b == 1) {
	            System.out.println("Enter the ID of the Item: ");
	            int id = in.nextInt();
	            Items i = Shop.getShop().getItem(id);
	            System.out.println("Enter quanitity: ");
	            int q = in.nextInt();
	            
	            if (i != null) {
	            	System.out.println("Enter email?");
	    	        String email = in.next();
	    	        System.out.println("Enter phone number?");
	    	        String password = in.next();
	    	        Client e=Shop.getShop().getClient(email);
	    	       
	    	        
	    	        if (e != null && e.password.equals(password)) {
	    	        	 Client_e nc = new Client_e(id,e.getName(), e.getEmail(),i.getName(),q+"");
	    	 	        Shop.getShop().addClient_e(nc);
	    	        	
	    	           
	    	        } else {
	    	            System.out.println("couldn't find your email and acount.");
	    	            System.out.println("Enter \n1.To retry \n2.return to mainu .");
	    	            int c = in.nextInt();
	    	            if (c == 1) {
	    	            	displayproducts();
	    	            } else if (c == 2) {
	    	                
	    	                printmainmenu();
	    	            }
	    	        }
	    	        
	                System.out.println("The all set up do you want to view customer?(y/n)");
	                String response = in.next();
	                
	                if (response.equals("y") || response.equals("yes")) {
	                   
	                   
	                    e_user();
	                    System.out.println("Enter \n1.to go back Main menu \n2. to Exit the system");

	                } else {
	                    System.out.println("Thanks for coming!");
	                    exitSystem();
	                    
	                }
	            }
	          }else {
	        	  printmainmenu();
	          }
	        
	    }
	    
//	   print customer with their respective object list  
	    public static void e_user()
	    {
	    	 ;
             System.out.println("--------- Clients-----------");
 	        
 	        Collection<Client_e> allclients = Shop.getShop().getClients_e();
 	        System.out.println(allclients.size());
 	        System.out.println("Id\t\t\t\tName\t\tEmail\t\t\t\tproduct\t\t\tquantity");
 	        for (Client_e c: allclients) {
 	            System.out.println(c.id + "\\t\t\t" + c.name + "\t\t\t" + c.email+ "\t\t\t" + c.product+ "\t\t\t" + c.quantity);
 	        }
 	        System.out.println("-------------------------------------");
 	        System.out.println("Enter 1.To go back 2.to add another");
 	        
 	        int b1 = in.nextInt();
 	        
 	        if (b1 == 1) {
 	           printmainmenu();
 	        }else if (b1 == 2) {
 	            displayproducts();
 	        }
	    }
	    
//	   add items to store 
	    public static void additems() {
	        System.out.println("How many Items do you want to add?");
	        int a = in.nextInt();
	        
	        for (int i = 0; i < a; i++) {
	            System.out.println("Enter Id for Item: ");
	            int id = in.nextInt();
	            System.out.println("Enter the name of the item: ");
	            String name = in.next();
	            
	            System.out.println("Enter the quantitiy: ");
	            int quantitiy = in.nextInt();

	            Items it = new Items(id, name,quantitiy);
	            Shop.getShop().addItem(it);
	            System.out.println("Item added successfully!");
	        }   
	        System.out.println("Enter 1.To go back 2.To add again");
	        int b = in.nextInt();
	        if (b == 1) {
	        	printmainmenu();
	        }else if (b == 2) {
	            additems();
	        }
	    }
	    
//	   print customer list
	    public static void viewusers() {
	    
	        System.out.println("--------- store Name---------");
	        System.out.println("--------- Clients-----------");
	        
	        Collection<Client> allclients = Shop.getShop().getClients();
	        System.out.println(allclients.size());
	        System.out.println("Id\t\tName\t\tEmail");
	        for (Client c: allclients) {
	            System.out.println(c.id + "\t\t" + c.name + "\t\t" + c.email);
	        }
	        System.out.println("-------------------------------------");
	        System.out.println("Enter 1.To go back 2.Exit");
	        
	        int b = in.nextInt();
	        
	        if (b == 1) {
	           printmainmenu();
	        }else if (b == 2) {
	            exitSystem();
	        }
	    }
	    
	   
}
