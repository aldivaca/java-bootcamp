package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalog {

	List<Item> catalogItems;

	public Catalog() {
		catalogItems = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		catalogItems.add(item);
	}

	public Iterator<Item> iterator() {
		return new CatalogIterator();
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
