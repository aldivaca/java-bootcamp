package model;

import java.util.Iterator;

import utils.CashDiscount;
import utils.Context;
import utils.CreditCardDiscount;
import utils.DiscountStrategy;
import utils.PayPalDiscount;
import utils.PaymentFactory;
import utils.SingletonCounter;

public class ShoppingCart {

	public long idNumber;
	public Catalog chosenItems;
	public PaymentMethod paymentMethod;
	public float total;

	public ShoppingCart(SingletonCounter singleton, String paymentMethod) {
		this.idNumber = singleton.nextId();
		this.paymentMethod = new PaymentFactory().getPaymentMethod(paymentMethod);
		this.chosenItems = new Catalog();
		this.total = getTotal();
	}

	public void addItem(Item item) {
		chosenItems.addItem(item);
	}

	public Catalog getChosenItems() {
		return chosenItems;
	}

	public long getIdNumber() {
		return idNumber;
	}

	public void setTotal() {
		Context context;
		DiscountStrategy strategy;
		if (this.paymentMethod.getClass() == CreditCard.class) {
			strategy = new CreditCardDiscount();
			context = new Context(this.chosenItems, strategy);
			total = context.getResult();
		} else {
			if (this.paymentMethod.getClass() == Cash.class) {
				strategy = new CashDiscount();
				context = new Context(this.chosenItems, strategy);
				total = context.getResult();
			} else {
				strategy = new PayPalDiscount();
				context = new Context(this.chosenItems, strategy);
				total = context.getResult();
			}
		}
	}

	public float getTotal() {
		return total;
	}

	public float getSubTotal() {
		Iterator<Item> it = chosenItems.iterator();
		float subtotal = 0;
		while (it.hasNext()) {
			subtotal += it.next().getPrice();
		}
		return subtotal;
	}

	public String mostrarCatálogo() {
		if (chosenItems == null) {
			return "";
		} else {
			Iterator<Item> it = chosenItems.iterator();
			StringBuilder builder = new StringBuilder("\n");
			while (it.hasNext()) {
				builder.append(it.next().toString());
				builder.append("\n");
			}
			return builder.toString();
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("N°= ");
		builder.append(idNumber);
		builder.append("\n");
		builder.append("Catálogo= ");
		builder.append(mostrarCatálogo());
		builder.append("Tipo de Pago= ");
		builder.append(paymentMethod);
		builder.append("\n");
		builder.append("Subtotal= ");
		builder.append(getSubTotal());
		builder.append("\n");
		builder.append("Total= ");
		builder.append(total);
		builder.append("\n");
		return builder.toString();
	}

}
