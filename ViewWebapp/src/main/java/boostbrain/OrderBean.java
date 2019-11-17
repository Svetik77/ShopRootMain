package boostbrain;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import boostbrain.domain.Order;

@Named
@SessionScoped
public class OrderBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private Order order;
	private long id;
	private String name;
	private int price;
	private int quantity;
	
	
	
	public OrderBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
 

	@Override
	public String toString() {
		return "OrderBean [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
