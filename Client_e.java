package storeManagmentSystem;

public class Client_e{
	
	String name;
    String product;
    String quantity;
    String email;
    int id;
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client_e(int id,String name, String email,String product,String quantity) {
		 this.name = name;
	        this.product = product;
	        this.quantity = quantity;
	        this.email=email;
	    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 


}
