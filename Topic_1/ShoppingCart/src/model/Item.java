package model;


public class Item {

	String name;
	float price;

	public Item(String name, float price, boolean isNew) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String toString() {
		StringBuilder r = new StringBuilder("* ");
		r.append(name);
		while (r.length() < 35) {
			r.append(".");
		}
		r.append("$ ");
		r.append(price);
		return r.toString();
	}

}
