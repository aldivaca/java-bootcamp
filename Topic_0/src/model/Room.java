package model;

public class Room {

	private String name;
	private int area;
	private Door[] doors;
	private Window[] windows;

	public Room() {
		name = "";
		area = 0;
		doors = null;
		windows = null;
	}

	public Room(String name, int area, Door[] doors, Window[] windows) {
		this.name = name;
		this.area = area;
		this.doors = doors;
		this.windows = windows;
	}

	public Room(Room r) {
		this.name = r.name;
		this.area = r.area;
		this.doors = r.doors;
		this.windows = r.windows;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Door[] getDoors() {
		return doors;
	}

	public void setDoors(Door[] doors) {
		this.doors = doors;
	}

	public Window[] getWindows() {
		return windows;
	}

	public void setWindows(Window[] windows) {
		this.windows = windows;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nombre=");
		builder.append(name);
		builder.append(" Area=");
		builder.append(area);
		builder.append(" Cantidad de Puertas=");
		builder.append(doors.length);
		builder.append(" [ ");
		builder.append("\n");
		for (int i = 0; i < doors.length; i++) {
			builder.append(doors[i].toString());
			builder.append(" ");
		}
		builder.append("\n");
		builder.append("]");
		builder.append("\n");
		builder.append(" Cantidad de Ventanas=");
		builder.append(windows.length);
		builder.append(" [ ");
		builder.append("\n");
		for (int i = 0; i < windows.length; i++) {
			builder.append(windows[i].toString());
			builder.append(" ");
		}
		builder.append("\n");
		builder.append("]");
		builder.append("\n");
		return builder.toString();
	}

}
