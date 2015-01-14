package utils;

import model.Cash;
import model.CreditCard;
import model.PayPal;
import model.PaymentMethod;

public class PaymentFactory {

	public PaymentMethod getPaymentMethod(String type) {
		if ("tarjeta".equals(type)) {
			return new CreditCard();
		} else {
			if ("paypal".equals(type)) {
				return new PayPal();
			} else {
				return new Cash();
			}
		}
	}
}
