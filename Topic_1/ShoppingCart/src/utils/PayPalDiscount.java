package utils;

import java.util.Iterator;

import model.Catalog;
import model.Item;

public class PayPalDiscount implements DiscountStrategy {

	public PayPalDiscount() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public float calcularTotal(Catalog cart) {
		Item currentItem;
		float price;
		float descuento = 0;
		float total = 0;
		Iterator<Item> it = cart.iterator();
		while (it.hasNext()) {
			currentItem = it.next();
			price = currentItem.getPrice();
			total += price;
			if (descuento > price) {
				descuento = price;
			}
		}
		return total - descuento;
	}

}
