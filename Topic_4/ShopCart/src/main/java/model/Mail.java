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

	public void doUpdate(String notification) {
		System.out.println("Se notific� a " + nombre + " al mail " + mail + " sobre :" + notification);
	}

}
