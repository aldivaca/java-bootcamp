package model;

public class Cash extends PaymentMethod {

	public Cash() {
		this.name = "Efectivo";
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		return builder.toString();
	}
}
