package boostbrain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import boostbrain.domain.Order;
import boostbrain.domain.Thing;
import boostbrain.ejb.OrderManagerBean;
import boostbrain.ejb.ThingsManagerBean;

@Named
@SessionScoped
public class OrderBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private int price;
//	private int quantity;
	
	private Order order;
	@EJB
	private OrderManagerBean orderManagerBean;
	@EJB
	private ThingsManagerBean  thingsManagerBean;
	
	public OrderBean() {
	 
	}
	
	/** if no order created */
	public void createOrder() {
		if(order == null) {
			orderManagerBean.createOrder();
		} // else do nothing
	}
	
	/** if no order created */
	public void createThing() {
		 
		thingsManagerBean.createThing(name, price);
	}

	/**return List of Things*/
	public List<Thing> getThingsList() {
		return thingsManagerBean.getThings();
	}
	
	
	/** if no order created */
	public void addhing(Thing thing) {
		/** before Order we can not add Thing */
		if(order == null) {
			return;
		}
		// getQuantity
		orderManagerBean.addToOrder(thing.getId(), order.getId(), 1);
	}
	
	

	/** OrderBean java getThingsListInOrder(long orderId) from OrderManagerBean<br>
	 * to return List we need method in EJB OrderManagerBean <br> 
	 return List of  display in xhtml what was put in the basket bucket Korzina */
	public List<Thing> getThingsListInOrder() {
		if(order == null) {
			return Collections.emptyList();
		}
		return orderManagerBean.getThingsListInOrder(order.getId());
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
		return "OrderBean [id=" + id + ", name=" + name + ", price=" + price +  "]";
	}

 

}
