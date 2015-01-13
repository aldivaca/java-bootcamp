package model;

public class House {

	private String adress;
	private Floor[] floorArray;
	private Garden garden;
	private Backyard backyard;

	public House() {
		adress = "";
		floorArray = null;
		garden = null;
		backyard = null;
	}

	public House(String adress, Floor[] floorArray, Garden garden, Backyard backyard) {
		this.adress = adress;
		this.floorArray = floorArray;
		this.garden = garden;
		this.backyard = backyard;
	}

	public House(House h) {
		this.adress = h.adress;
		this.floorArray = h.floorArray;
		this.garden = h.garden;
		this.backyard = h.backyard;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Floor[] getFloorArray() {
		return floorArray;
	}

	public void setFloorArray(Floor[] floorArray) {
		this.floorArray = floorArray;
	}

	public Garden getGarden() {
		return garden;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
	}

	public Backyard getBackyard() {
		return backyard;
	}

	public void setBackyard(Backyard backyard) {
		this.backyard = backyard;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CASA: ");
		builder.append("Dirección= ");
		builder.append(adress);
		builder.append(" Jardín= ");
		builder.append(garden.toString());
		builder.append(" Patio= ");
		builder.append(backyard.toString());
		builder.append(" Cantidad de pisos= ");
		builder.append(floorArray.length);
		builder.append(" [ ");
		builder.append("\n");
		for (int i = 0; i < floorArray.length; i++) {
			builder.append(floorArray[i].toString());
			builder.append(" ");
		}
		builder.append("\n");
		builder.append("]");
		builder.append("\n");
		return builder.toString();
	}

}
