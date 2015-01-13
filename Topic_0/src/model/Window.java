package model;

public class Window extends Opening {

	private int totalGlasses;
	private int floorDistance;
	private boolean fixed;

	public Window() {
		super();
		this.totalGlasses = 0;
		this.fixed = false;
		this.floorDistance = 0;
	}

	public Window(long id, int height, int width, Material material, int totalGlasses, int floor, boolean fix) {
		super(id, height, width, material);
		this.totalGlasses = totalGlasses;
		this.fixed = fix;
		this.floorDistance = floor;
	}

	public Window(Window v) {
		super(v.id, v.height, v.width, v.material);
		this.totalGlasses = v.totalGlasses;
		this.fixed = v.fixed;
		this.floorDistance = v.floorDistance;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public Material getMaterial() {
		return material;
	}

	@Override
	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getTotalGlasses() {
		return totalGlasses;
	}

	public void setTotalGlasses(int totalGlasses) {
		this.totalGlasses = totalGlasses;
	}

	public int getFloorDistance() {
		return floorDistance;
	}

	public void setFloorDistance(int floorDistance) {
		this.floorDistance = floorDistance;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	@Override
	public String toString() {
		String s = super.toString();
		StringBuilder builder = new StringBuilder();
		builder.append(" Cantidad de Vidrios= ");
		builder.append(totalGlasses);
		builder.append(" Distancia al piso= ");
		builder.append(floorDistance);
		builder.append(" Esta fija= ");
		builder.append(fixed);
		builder.append("\n");
		s += builder.toString();
		return s;
	}

}
