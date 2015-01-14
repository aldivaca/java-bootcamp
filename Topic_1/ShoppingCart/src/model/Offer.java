package model;

import java.util.Iterator;

public class Offer extends Item {

	public Catalog offerContent;

	public Offer(String name, float price) {
		super(name, price);
		offerContent = new Catalog();
	}

	public void addItem(Item item) {
		offerContent.addItem(item);
	}

	public String toString() {
		Iterator<Item> it = offerContent.iterator();

		StringBuilder builder = new StringBuilder("* ");
		builder.append(name);
		while (builder.length() < 35) {
			builder.append(".");
		}
		builder.append("$ ");
		builder.append(price);
		builder.append("\n");
		while (it.hasNext()) {
			StringBuilder itemBuilder = new StringBuilder("");
			itemBuilder.append("    - ");
			Item item = it.next();
			itemBuilder.append(item.getName());
			while (itemBuilder.length() < 35) {
				itemBuilder.append(".");
			}
			itemBuilder.append("$ ");
			itemBuilder.append(item.getPrice());
			itemBuilder.append("\n");
			builder.append(itemBuilder.toString());
		}
		return builder.toString();
	}

}
