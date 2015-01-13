package model;

public class Floor {

	private int number;
	private Room[] rooms;

	public Floor() {
		number = 0;
		rooms = null;
	}

	public Floor(int num, Room[] r) {
		number = num;
		rooms = r;
	}

	public Floor(Floor f) {
		this.number = f.number;
		this.rooms = f.rooms;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Numero de Piso= ");
		builder.append(number);
		builder.append(" Cantidad de Habitaciones= ");
		builder.append(rooms.length);
		builder.append("[ ");
		builder.append("\n");
		for (int i = 0; i < rooms.length; i++) {
			builder.append(rooms[i].toString());
			builder.append("\n");
		}
		builder.append("\n");
		builder.append("]");
		builder.append("\n");
		return builder.toString();
	}
}
