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

public class LowerClassHouseBuilder implements HouseBuilder {

	private House house;

	public LowerClassHouseBuilder() {
		house = new House();
	}

	@Override
	public void buildFloorArray() {
		Room[] rooms = new Room[3];
		Room r = buildRoom("Cocina/Comedor");
		rooms[0] = r;
		r = buildRoom("Dormitorio");
		rooms[1] = r;
		r = buildRoom("Baño");
		rooms[2] = r;

		Floor[] floorArray = new Floor[1];
		Floor floor = new Floor(0, rooms);
		floorArray[0] = floor;

		house.setFloorArray(floorArray);
	}

	public Room buildRoom(String name) {
		Material m = new Material("Chapa", 2);
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		Door[] doors = new Door[randomNum];
		for (int i = 0; i < randomNum; i++) {
			doors[i] = new Door(i + 1, 200, 300, m, 2);
		}
		randomNum = rand.nextInt((2 - 1) + 1) + 1;
		Window[] windows = new Window[randomNum];
		for (int i = 0; i < randomNum; i++) {
			windows[i] = new Window(i + 1, 200, 300, m, 2, 50, true);
		}
		Room r = new Room(name, 9, doors, windows);
		return r;
	}

	@Override
	public void buildAdress() {
		house.setAdress("Una Direccion 1526 B° AlgunLugar");
	}

	@Override
	public House getHouse() {
		return house;
	}

	@Override
	public void buildGarden() {
		Garden g = new Garden(false, false, 1);
		house.setGarden(g);
	}

	@Override
	public void buildBackyard() {
		Backyard b = new Backyard(10, false, false);
		house.setBackyard(b);
	}

}
