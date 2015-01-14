package view;

import java.util.Random;

import model.Item;
import model.Offer;
import model.ShoppingCart;
import utils.SingletonCounter;

public class Main {

	public static String[] paymentData = new String[3];
	public static Item[] itemsData = new Item[10];
	public static Offer[] offersData = new Offer[5];

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
		itemsData[6] = new Item("Funda de Tablet Rígida", 260);
		itemsData[7] = new Item("PlayStation", 6213);
		itemsData[8] = new Item("Reproductora de BlueRay", 1200);
		itemsData[9] = new Item("Parlantes", 800);

		Offer offer = new Offer("Combo PC", 8756);
		offer.addItem(itemsData[1]);
		offer.addItem(itemsData[4]);
		offer.addItem(itemsData[5]);
		offersData[0] = offer;
		offer = new Offer("Combo Play", 6352);
		offer.addItem(itemsData[7]);
		offer.addItem(itemsData[9]);
		offersData[1] = offer;
		offer = new Offer("Combo Cine", 5800);
		offer.addItem(itemsData[0]);
		offer.addItem(itemsData[8]);
		offer.addItem(itemsData[9]);
		offersData[2] = offer;
		offer = new Offer("Combo Tablet", 2350);
		offer.addItem(itemsData[2]);
		offer.addItem(itemsData[5]);
		offer.addItem(itemsData[6]);
		offersData[3] = offer;
		offer = new Offer("Combo Cine+PC", 13420);
		offer.addItem(offersData[0]);
		offer.addItem(offersData[2]);
		offersData[4] = offer;

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
			int randomOffers = r.nextInt(5);
			for (int j = 0; j < randomOffers; j++) {
				int offerItem = r.nextInt(5);
				Offer newItem = offersData[offerItem];
				cart.addItem(newItem);
			}
			cart.setTotal();
			System.out.println("Este es el carro.." + cart);
			System.out.println("\n");
		}
	}
}
