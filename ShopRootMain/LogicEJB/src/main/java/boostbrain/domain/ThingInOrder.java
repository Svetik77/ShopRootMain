package boostbrain.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/** in 1 order many things , and in 1 thing many orders*/
/** can get ONLY ONE Thin(tovar) or ONLY ONE Order*/
@Entity
public class ThingInOrder {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/** Link reference to  things (tovar)  only */
	@ManyToOne
	private Thing thing;
	
	/** 1.1.1.1. -> 1   Link reference to  Order  */
	@ManyToOne
	private Order order;
	
	/**  */
	private  int quantity;  


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Thing getThing() {
		return thing;
	}

	public void setThing(Thing thing) {
		this.thing = thing;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
