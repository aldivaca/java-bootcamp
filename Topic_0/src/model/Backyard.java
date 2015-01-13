package model;

public class Backyard {

	private int area;
	private boolean pool;
	private boolean barbecue;

	public Backyard() {
		area = 0;
		pool = false;
		barbecue = false;
	}

	public Backyard(int area, boolean pool, boolean barbecue) {
		this.area = area;
		this.pool = pool;
		this.barbecue = barbecue;
	}

	public Backyard(Backyard b) {
		this.area = b.area;
		this.pool = b.pool;
		this.barbecue = b.barbecue;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public boolean isPool() {
		return pool;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}

	public boolean isBarbecue() {
		return barbecue;
	}

	public void setBarbecue(boolean barbecue) {
		this.barbecue = barbecue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Area= ");
		builder.append(area);
		builder.append(" Pileta=");
		builder.append(pool);
		builder.append(" Asador/Quincho=");
		builder.append(barbecue);
		builder.append("\n");
		return builder.toString();
	}

}
