package view;

import model.ShoppingCart;
import utils.SingletonCounter;

public class Main {

	public static void main(String[] args) {
		ShoppingCart cart;
		SingletonCounter singleton = SingletonCounter.getInstance();
		for (int i = 0; i < 6; i++) {
			cart = new ShoppingCart(singleton, "Efectivo");
			System.out.println("Este es el carro.." + cart);
		}
	}
}
