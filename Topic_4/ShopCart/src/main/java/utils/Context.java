package utils;

import model.Catalog;

public class Context {

	Catalog cart;
	DiscountStrategy strategy;

	public Context(Catalog choosenItems, DiscountStrategy strategy) {
		this.cart = choosenItems;
		this.strategy = strategy;
	}

	public void setStrategy(DiscountStrategy strategy) {
		this.strategy = strategy;
	}

	public Catalog getChoosenItems() {
		return cart;
	}

	public float getResult() {
		return strategy.calcularTotal(cart);
	}
}
