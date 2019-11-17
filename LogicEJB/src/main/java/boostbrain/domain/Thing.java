package boostbrain.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Thing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int price;

	/** oneToMany : 1 -> 1.... one things (goods) can have many orders */
	@OneToMany /** @ManyToOne ThingInOrder */
	private List<ThingInOrder> thingInOrders;

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

	public List<ThingInOrder> getThingInOrders() {
		return thingInOrders;
	}

	public void setThingInOrders(List<ThingInOrder> thingInOrders) {
		this.thingInOrders = thingInOrders;
	}
}
