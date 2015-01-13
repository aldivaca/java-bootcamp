package builder;

import model.House;

public interface HouseBuilder {

	public void buildFloorArray();

	public void buildAdress();

	public void buildGarden();

	public void buildBackyard();

	public House getHouse();
}
