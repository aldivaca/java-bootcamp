package model;

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
		idNumber = singleton.nextId();
		this.paymentMethod = new PaymentFactory().getPaymentMethod(paymentMethod);
	}

	public void addItem(Item item) {
		chosenItems.addItem(item);
	}

	public Catalog getChosenItems() {
		return chosenItems;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("N°= ");
		builder.append(idNumber);
		builder.append(" Catálogo= ");
		builder.append(chosenItems);
		builder.append(" Tipo de Pago= ");
		builder.append(paymentMethod);
		builder.append(" Total= ");
		builder.append(total);
		builder.append("\n");
		return builder.toString();
	}

}
