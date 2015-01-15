package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import utils.CartObserver;
import utils.CartSubject;

public class Catalog implements CartSubject {

	public List<Item> catalogItems;
	public Set<CartObserver> cartObservers;
	public String notification;

	public Catalog() {
		catalogItems = new ArrayList<Item>();
		cartObservers = new HashSet<CartObserver>();
	}

	public void addItem(Item item) {
		catalogItems.add(item);
		notification = "El item/oferta " + item.getName() + " fue agregado";
		doNotify();
	}

	public Item getItem(int index) {
		return catalogItems.get(index);
	}

	public void setPrice(String name, float price) {
		Iterator<Item> it = catalogItems.iterator();
		while (it.hasNext()) {
			Item aux = it.next();
			if (aux.getName() == name) {
				int index = catalogItems.indexOf(aux);
				aux.setPrice(price);
				catalogItems.remove(index);
				catalogItems.add(index, aux);
				notification = "El item/oferta " + aux.getName() + " cambió de precio";
				doNotify();
				break;
			}
		}
	}

	public Iterator<Item> iterator() {
		return new CatalogIterator();
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
			Iterator<CartObserver> it = cartObservers.iterator();
			while (it.hasNext()) {
				CartObserver cartObserver = it.next();
				cartObserver.doUpdate(notification);
			}
		}
	}

	class CatalogIterator implements Iterator<Item> {
		int currentIndex = 0;

		@Override
		public boolean hasNext() {
			if (currentIndex >= catalogItems.size()) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Item next() {
			return catalogItems.get(currentIndex++);
		}

		@Override
		public void remove() {
			catalogItems.remove(--currentIndex);
		}

	}

}
