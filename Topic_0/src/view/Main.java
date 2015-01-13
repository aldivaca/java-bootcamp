package view;

import model.House;
import builder.HouseBuilder;
import builder.HouseDirector;
import builder.LowerClassHouseBuilder;
import builder.MiddleClassHouseBuilder;
import builder.UpperClassHouseBuilder;

public class Main {

	public static void main(String[] args) {
		HouseBuilder houseBuilder = new LowerClassHouseBuilder();
		HouseDirector houseDirector = new HouseDirector(houseBuilder);
		houseDirector.constructHouse();
		House house = houseDirector.getHouse();
		System.out.println("Una casa con bajos ingresos: \n" + house + "\n");

		houseBuilder = new MiddleClassHouseBuilder();
		houseDirector = new HouseDirector(houseBuilder);
		houseDirector.constructHouse();
		house = houseDirector.getHouse();
		System.out.println("Una casa con ingresos medios: \n" + house + "\n");

		houseBuilder = new UpperClassHouseBuilder();
		houseDirector = new HouseDirector(houseBuilder);
		houseDirector.constructHouse();
		house = houseDirector.getHouse();
		System.out.println("Una casa con altos ingresos: \n" + house);
	}

}
