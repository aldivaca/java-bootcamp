package model;

public class Door extends Opening {

	private int totalLocks;

	public Door() {
		super();
		this.totalLocks = 0;
	}

	public Door(long id, int height, int width, Material material, int totalLocks) {
		super(id, height, width, material);
		this.totalLocks = totalLocks;
	}

	public Door(Door p) {
		super(p.id, p.height, p.width, p.material);
		this.totalLocks = p.totalLocks;
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

	public int getTotalLocks() {
		return totalLocks;
	}

	public void setTotalLocks(int totalLocks) {
		this.totalLocks = totalLocks;
	}

	@Override
	public String toString() {
		String s = super.toString();
		StringBuilder builder = new StringBuilder();
		builder.append("Cantidad de Trabas/Cerraduras= ");
		builder.append(totalLocks);
		builder.append("\n");
		s += builder.toString();
		return s;
	}

}
