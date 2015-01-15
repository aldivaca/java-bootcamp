package view;

import java.util.Random;

import model.Catalog;
import model.Item;
import model.Mail;
import model.Offer;
import model.ShoppingCart;
import model.Transaction;
import utils.SingletonCounter;

public class Main {

	public static String[] paymentData = new String[3];
	public static Catalog catalog = new Catalog();

	public static void setData() {
		Item[] itemsData = new Item[10];
		Offer[] offersData = new Offer[5];

		paymentData[0] = "Efectivo";
		paymentData[1] = "Tarjeta";
		paymentData[2] = "PayPal";

		itemsData[0] = new Item("TV LED", 4200, true);
		itemsData[1] = new Item("Computadora", 8562, true);
		itemsData[2] = new Item("Tablet", 1950, true);
		itemsData[3] = new Item("Celular", 2656, true);
		itemsData[4] = new Item("Mouse", 150, true);
		itemsData[5] = new Item("Teclado", 450, true);
		itemsData[6] = new Item("Funda de Tablet Rígida", 260, true);
		itemsData[7] = new Item("PlayStation", 6213, true);
		itemsData[8] = new Item("Reproductora de BlueRay", 1200, true);
		itemsData[9] = new Item("Parlantes", 800, true);

		Offer offer = new Offer("Combo PC", 8756, true);
		offer.addItem(itemsData[1]);
		offer.addItem(itemsData[4]);
		offer.addItem(itemsData[5]);
		offersData[0] = offer;
		offer = new Offer("Combo Play", 6352, true);
		offer.addItem(itemsData[7]);
		offer.addItem(itemsData[9]);
		offersData[1] = offer;
		offer = new Offer("Combo Cine", 5800, true);
		offer.addItem(itemsData[0]);
		offer.addItem(itemsData[8]);
		offer.addItem(itemsData[9]);
		offersData[2] = offer;
		offer = new Offer("Combo Tablet", 2350, true);
		offer.addItem(itemsData[2]);
		offer.addItem(itemsData[5]);
		offer.addItem(itemsData[6]);
		offersData[3] = offer;
		offer = new Offer("Combo Cine+PC", 13420, true);
		offer.addItem(offersData[0]);
		offer.addItem(offersData[2]);
		offersData[4] = offer;

		for (int i = 0; i < itemsData.length; i++) {
			catalog.addItem(itemsData[i]);
			if (i == 7) {
				catalog.addObserver(new Mail());
			}
		}
		for (int i = 0; i < offersData.length; i++) {
			catalog.addItem(offersData[i]);
		}

	}

	public static void main(String[] args) {
		setData();

		ShoppingCart cart = null;
		SingletonCounter singleton = SingletonCounter.getInstance();
		Random r = new Random();
		for (int i = 0; i < 2; i++) {
			int randomPayment = r.nextInt(3);
			String payment = paymentData[randomPayment];
			cart = new ShoppingCart(singleton, payment);
			int randomItems = r.nextInt(15);
			for (int j = 0; j < randomItems; j++) {
				int indexItem = r.nextInt(15);
				Item newItem = catalog.getItem(indexItem);
				cart.addItem(newItem);
			}
			cart.setTotal();
			System.out.println("Este es el carro.." + cart);
			System.out.println("\n");
		}

		catalog.addObserver(new Mail("El Vendedor", "elVendedor@hotmail.com"));
		catalog.setPrice("Parlantes", 620);

		Transaction t = new Transaction(cart);
		t.addObserver(new Mail());
		t.execute();
	}
}
