package builder;

import model.House;

public class HouseDirector {

	private HouseBuilder houseBuilder = null;

	public HouseDirector(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	public void constructHouse() {
		houseBuilder.buildFloorArray();
		houseBuilder.buildAdress();
		houseBuilder.buildBackyard();
		houseBuilder.buildGarden();
	}

	public House getHouse() {
		return houseBuilder.getHouse();
	}

}
