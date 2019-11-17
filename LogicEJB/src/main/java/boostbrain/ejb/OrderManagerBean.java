package boostbrain.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import boostbrain.domain.Order;
import boostbrain.domain.Thing;
import boostbrain.domain.ThingInOrder;

/**  */
/**  */
@Stateless
@LocalBean
public class OrderManagerBean {

	/**<persistence-unit name="examplePU">*/
	@PersistenceContext(unitName = "LogicEJB")
	private EntityManager entityManager;
	/** create order  */
	public Order createOrder() {
		Order order = new Order();
		entityManager.persist(order);
		return order;
	}
 
	
	/**
	 * @param quantity   */ 
	public boolean addToOrder(long thingId, long orderId, int quantity) {
		/**find thingId and  orderId*/
		Thing thing = entityManager.find(Thing.class, thingId);
		if(thing == null) {
			return false;
		}
		Order order = entityManager.find(Order.class, orderId);
		if(order == null) {
			return false;
		}
		
		ThingInOrder  thingInOrder = new ThingInOrder();
		thingInOrder.setOrder(order);
		thingInOrder.setThing(thing);
		thingInOrder.setQuantity(quantity);
		entityManager.persist(thingInOrder);
		return true;
	}
	
	
	/**  OrderManagerBean getThingsListInOrder for OrderBean<br>
	 * @ManyToOne ThingInOrder private Thing thing;*/ 
	public List<Thing> getThingsListInOrder(long orderId) {
		Order order = entityManager.find(Order.class, orderId);
		if(order == null) {
			return Collections.emptyList();
		}
		
		List<ThingInOrder> thingInOrders = order.getThingInOrders();
		List<Thing> resultList = new ArrayList<>();
		
		for (ThingInOrder thingInOrder : thingInOrders) {
			resultList.add(thingInOrder.getThing());
		}
		
		return resultList ;
	}
	
	/**  */ 
	public boolean addToOrderFlag(long thingId, long orderId) {
		boolean flag = false;
		/**find thingId and  orderId*/
		Thing thing = entityManager.find(Thing.class, thingId);
		if(thing == null) {
			flag = false;
		}
		Order order = entityManager.find(Order.class, orderId);
		if(order == null) {
			flag = false;
		}
		return flag;
	}

	
	
}
