package boostbrain.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import boostbrain.domain.Order;
import boostbrain.domain.Thing;
import boostbrain.domain.ThingInOrder;

/**  */
/**  */
@Stateless
@LocalBean
public class ThingsManagerBean {

	@PersistenceContext(unitName = "LogicEJB")
	private EntityManager entityManager;
	/** create order  */
	public Order createOrder() {
		Order order = new Order();
		entityManager.persist(order);
		return order;
	}
	/** adminka  simelar delete thing*/ 
	public Thing createThing(String name, int price) {
		Thing thing = new Thing();
		thing.setName(name);
		thing.setPrice(price);
		entityManager.persist(thing);
		return thing;
	}
	
	 
	
}
