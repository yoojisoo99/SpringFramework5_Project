package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class OrderSpringTest {
	ApplicationContext context;
	
	@BeforeEach
	void init() {
		//SpringBean Container 객체생성
		context = new GenericXmlApplicationContext("classpath:mylab-order-di.xml");		
	}

	@Test
	void shoppingcart() {
		ShoppingCart cart = context.getBean("cart", ShoppingCart.class);
		assertNotNull(cart);
		assertEquals(2, cart.getProducts().size());
		assertEquals("노트북", cart.getProducts().get(0).getName());
		assertEquals("스마트폰", cart.getProducts().get(1).getName());
		System.out.println(cart.getProducts().size());
	}
	
	@Test
	void orderservice() {
		OrderService order = context.getBean("order", OrderService.class);
		double expectedTotal = 950000.0;
	    assertEquals(expectedTotal, order.calculateOrderTotal());
	    System.out.println(order.calculateOrderTotal());
	}
	
	
	
	

}
