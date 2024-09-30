package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
	public void checkout(String status) {
		System.out.println("check out method from shopping card called");
		
	}
	
	public int quantity() {
		return 2;
	}
}
