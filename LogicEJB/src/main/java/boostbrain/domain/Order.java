package boostbrain.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/** oneToMany : 1 order can have many things (goods)   BUT : */
/** manyToMany : 1 things (goods) can have many  orders
 * for that we use an other class ThingInOrder , 
 * it shows connection  between entities */

@Entity
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/** oneToMany : 1 -> 1....  one order can have many things (goods)  )*/
	 @OneToMany  /** @ManyToOne ThingInOrder */
	private List<ThingInOrder>  thingInOrders;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ThingInOrder> getThingInOrders() {
		return thingInOrders;
	}

	public void setThingInOrders(List<ThingInOrder> thingInOrders) {
		this.thingInOrders = thingInOrders;
	}
	 
	 
}
