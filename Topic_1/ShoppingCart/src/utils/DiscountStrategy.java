package utils;

import model.Catalog;

public interface DiscountStrategy {

	public float calcularTotal(Catalog cart);

}
