package view;

import java.util.Random;

import model.Item;
import model.ShoppingCart;
import utils.SingletonCounter;

public class Main {

	public static String[] paymentData = new String[3];
	public static Item[] itemsData = new Item[10];

	public static void cargarDatos() {
		paymentData[0] = "Efectivo";
		paymentData[1] = "Tarjeta";
		paymentData[2] = "PayPal";

		itemsData[0] = new Item("TV LED", 4200);
		itemsData[1] = new Item("Computadora", 8562);
		itemsData[2] = new Item("Tablet", 1950);
		itemsData[3] = new Item("Celular", 2656);
		itemsData[4] = new Item("Mouse", 150);
		itemsData[5] = new Item("Teclado", 450);
		itemsData[6] = new Item("PortaNotebook", 260);
		itemsData[7] = new Item("PlayStation", 6213);
		itemsData[8] = new Item("Reproductora de BlueRay", 1200);
		itemsData[9] = new Item("Parlantes", 800);

	}

	public static void main(String[] args) {
		cargarDatos();

		ShoppingCart cart;
		SingletonCounter singleton = SingletonCounter.getInstance();
		Random r = new Random();
		for (int i = 0; i < 2; i++) {
			int randomPayment = r.nextInt(3);
			String payment = paymentData[randomPayment];
			cart = new ShoppingCart(singleton, payment);
			int randomItems = r.nextInt(10);
			for (int j = 0; j < randomItems; j++) {
				int indexItem = r.nextInt(10);
				Item newItem = itemsData[indexItem];
				cart.addItem(newItem);
			}
			cart.setTotal();
			System.out.println("Este es el carro.." + cart);
			System.out.println("\n");
		}
	}
}
