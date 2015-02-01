package model;

public class CreditCard extends PaymentMethod {

	public String ownerName;
	public long number;

	public CreditCard() {
		this.name = "Tarjeta de Credito";
		this.ownerName = "Un dueño de la tarjeta de credito";
		this.number = 1234567890;
	}

	public CreditCard(String owner, long number) {
		this.name = "Tarjeta de Credito";
		this.ownerName = owner;
		this.number = number;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" Titular= ");
		builder.append(ownerName);
		builder.append(" Número= ");
		builder.append(number);
		return builder.toString();
	}

}
