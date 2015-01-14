package utils;

import java.util.Iterator;

import model.Catalog;
import model.Item;

public class CreditCardDiscount implements DiscountStrategy {

	@Override
	public float calcularTotal(Catalog cart) {
		Item currentItem;
		float descuento;
		float total = 0;
		Iterator<Item> it = cart.iterator();
		while (it.hasNext()) {
			currentItem = it.next();
			total += currentItem.getPrice();
		}
		descuento = total / 10;
		return total - descuento;
	}
}
