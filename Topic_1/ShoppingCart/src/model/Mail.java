package model;

import utils.CartObserver;

public class Mail implements CartObserver {

	public String nombre;
	public String mail;

	public Mail() {
		nombre = "El Gerente";
		mail = "elGerente@gmail.com";
	}

	public Mail(String nombre, String mail) {
		this.nombre = nombre;
		this.mail = mail;
	}

	@Override
	public void doUpdate(String notification) {
		System.out.println("Se notificó a " + nombre + " al mail " + mail + " sobre :" + notification);
	}

}
