package model;

import utils.CashDiscount;
import utils.Context;
import utils.CreditCardDiscount;
import utils.DiscountStrategy;
import utils.PayPalDiscount;
import utils.PaymentFactory;
import utils.SingletonCounter;

public class ShoppingCart {

	private static SingletonCounter singleton = SingletonCounter.getInstance();
	public long idNumber;
	public Catalog chosenItems;
	public PaymentMethod paymentMethod;
	public float total;

	public ShoppingCart(String paymentMethod) {
		idNumber = singleton.getNumber();
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

}