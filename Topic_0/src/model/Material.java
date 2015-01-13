package model;

public class Material {

	private String name;
	private int resistance;

	public Material() {
		this.name = "No materials added";
		this.resistance = 0;
	}

	public Material(String name, int resistance) {
		this.name = name;
		this.resistance = resistance;
	}

	public Material(Material m) {
		this.name = m.name;
		this.resistance = m.resistance;
	}

	public String getName() {
		return name;
	}

	public void setName(String nombre) {
		this.name = nombre;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(" Nombre= ");
		sb.append(name);
		sb.append(" Resistencia= ");
		sb.append(resistance);
		return sb.toString();
	}

}
