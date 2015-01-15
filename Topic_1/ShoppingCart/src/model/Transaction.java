package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import utils.CartObserver;
import utils.CartSubject;

public class Transaction implements CartSubject {

	public long id;
	public Date date;
	public ShoppingCart detail;
	public Set<CartObserver> cartObservers;

	public Transaction(ShoppingCart cart) {
		this.id = cart.getIdNumber();
		date = new Date();
		detail = cart;
		cartObservers = new HashSet<CartObserver>();
	}

	public void execute() {
		doNotify();
	}

	@Override
	public void addObserver(CartObserver cartObserver) {
		cartObservers.add(cartObserver);
	}

	@Override
	public void removeObserver(CartObserver cartObserver) {
		cartObservers.remove(cartObserver);
	}

	@Override
	public void doNotify() {
		if (cartObservers != null) {

			String notification = "La transacción N° " + id + " fue realizada";
			Iterator<CartObserver> it = cartObservers.iterator();
			while (it.hasNext()) {
				CartObserver cartObserver = it.next();
				cartObserver.doUpdate(notification);
			}
		}
	}

}
