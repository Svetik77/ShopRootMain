package boostbrain.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import boostbrain.domain.Order;
import boostbrain.domain.Thing;

/**  */
/**  */
@Stateless
@LocalBean
public class ThingsManagerBean {

	/**<persistence-unit name="examplePU">*/
	@PersistenceContext(unitName = "LogicEJB")
	private EntityManager entityManager;
	/** create order  */
	public Order createOrder() {
		Order order = new Order();
		entityManager.persist(order);
		return order;
	}
	/** adminka  similar delete thing*/ 
//	public Thing createThing(String name, int price) {
	public Thing createThing(String name, int quantity) {
		Thing thing = new Thing();
		thing.setName(name);
//		thing.setPrice(price);
		thing.setQuantity(quantity);;
		entityManager.persist(thing);
		return thing;
	}
	
	public List<Thing> getThings() {
		String selectString = "select c from Thing c";
		TypedQuery<Thing> createQuery = 
				entityManager.createQuery(selectString , Thing.class);
		List<Thing> list = createQuery.getResultList();
		return list;
	}
	
}
