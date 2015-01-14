package utils;

import model.Cash;
import model.CreditCard;
import model.PayPal;
import model.PaymentMethod;

public class PaymentFactory {

	public PaymentMethod getPaymentMethod(String type) {
		if ("Tarjeta".equals(type)) {
			return new CreditCard();
		} else {
			if ("PayPal".equals(type)) {
				return new PayPal();
			} else {
				return new Cash();
			}
		}
	}
}
