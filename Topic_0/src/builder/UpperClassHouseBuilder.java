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

public class UpperClassHouseBuilder implements HouseBuilder {

	private House house;

	public UpperClassHouseBuilder() {
		house = new House();
	}

	@Override
	public void buildFloorArray() {
		Room[] rooms = new Room[7];
		Room r = buildRoom("Cocina");
		rooms[0] = r;
		r = buildRoom("Garage");
		rooms[1] = r;
		r = buildRoom("Comedor");
		rooms[2] = r;
		r = buildRoom("Living");
		rooms[3] = r;
		r = buildRoom("Escritorio");
		rooms[4] = r;
		r = buildRoom("Baño");
		rooms[5] = r;
		r = buildRoom("Habitacion de Huéspedes");
		rooms[6] = r;

		Floor[] floorArray = new Floor[2];
		Floor floor = new Floor(0, rooms);
		floorArray[0] = floor;

		rooms = new Room[6];
		r = buildRoom("Habitacion 1");
		rooms[0] = r;
		r = buildRoom("Habitación 2");
		rooms[1] = r;
		r = buildRoom("PlayRoom");
		rooms[2] = r;
		r = buildRoom("Baño 1");
		rooms[3] = r;
		r = buildRoom("Baño 2");
		rooms[4] = r;
		r = buildRoom("Habitación 3");
		rooms[5] = r;

		floor = new Floor(1, rooms);
		floorArray[1] = floor;

		house.setFloorArray(floorArray);
	}

	public Room buildRoom(String name) {
		Material m = new Material("Aluminio", 10);
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		Door[] doors = new Door[randomNum];
		for (int i = 0; i < randomNum; i++) {
			doors[i] = new Door(i + 1, 200, 300, m, 2);
		}
		randomNum = rand.nextInt((4 - 1) + 1) + 1;
		Window[] windows = new Window[randomNum];
		for (int i = 0; i < randomNum; i++) {
			windows[i] = new Window(i + 1, 200, 300, m, 2, 50, true);
		}
		Room r = new Room(name, 12, doors, windows);
		return r;
	}

	@Override
	public void buildAdress() {
		house.setAdress("Country Los Soles, Manzana A, Casa 5");
	}

	@Override
	public House getHouse() {
		return house;
	}

	@Override
	public void buildGarden() {
		Garden g = new Garden(false, true, 10);
		house.setGarden(g);
	}

	@Override
	public void buildBackyard() {
		Backyard b = new Backyard(40, true, true);
		house.setBackyard(b);
	}

}
