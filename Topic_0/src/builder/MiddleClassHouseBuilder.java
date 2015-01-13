package builder;

import java.util.Random;

import model.Backyard;
import model.Door;
import model.Floor;
import model.Garden;
import model.House;
import model.Material;
import model.Room;
import model.Window;

public class MiddleClassHouseBuilder implements HouseBuilder {

	private House house;

	public MiddleClassHouseBuilder() {
		house = new House();
	}

	@Override
	public void buildFloorArray() {
		Room[] rooms = new Room[6];
		Room r = buildRoom("Cocina");
		rooms[0] = r;
		r = buildRoom("Garage");
		rooms[1] = r;
		r = buildRoom("Comedor");
		rooms[2] = r;
		r = buildRoom("Dormitorio 1");
		rooms[3] = r;
		r = buildRoom("Dormitorio 2");
		rooms[4] = r;
		r = buildRoom("Baño");
		rooms[5] = r;

		Floor[] floorArray = new Floor[1];
		Floor floor = new Floor(0, rooms);
		floorArray[0] = floor;

		house.setFloorArray(floorArray);
	}

	public Room buildRoom(String name) {
		Material m = new Material("Madera", 5);
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		Door[] doors = new Door[randomNum];
		for (int i = 0; i < randomNum; i++) {
			doors[i] = new Door(i + 1, 200, 300, m, 2);
		}
		randomNum = rand.nextInt((3 - 1) + 1) + 1;
		Window[] windows = new Window[randomNum];
		for (int i = 0; i < randomNum; i++) {
			windows[i] = new Window(i + 1, 200, 300, m, 2, 50, true);
		}
		Room r = new Room(name, 9, doors, windows);
		return r;
	}

	@Override
	public void buildAdress() {
		house.setAdress("José Acevey 1840 B° Ayacucho");
	}

	@Override
	public House getHouse() {
		return house;
	}

	@Override
	public void buildGarden() {
		Garden g = new Garden(true, false, 2);
		house.setGarden(g);
	}

	@Override
	public void buildBackyard() {
		Backyard b = new Backyard(20, true, false);
		house.setBackyard(b);
	}

}
