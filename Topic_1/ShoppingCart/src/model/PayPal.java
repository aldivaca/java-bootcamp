package model;

public class PayPal extends PaymentMethod {

	public String user;
	public String password;

	public PayPal() {
		this.name = "PayPal";
		this.user = "AlgunUsuario";
		this.password = "UnaContraseña";
	}

	public PayPal(String user, String password) {
		this.name = "PayPal";
		this.user = user;
		this.password = password;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" Usuario= ");
		builder.append(user);
		builder.append(" Contraseña= ");
		builder.append(password);
		return builder.toString();
	}

}
