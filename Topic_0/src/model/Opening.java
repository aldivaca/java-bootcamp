package model;

public abstract class Opening {

	protected long id;
	protected int height;
	protected int width;
	protected Material material;

	public Opening() {
		this.id = 0;
		this.height = 0;
		this.width = 0;
		this.material = null;
	}

	public Opening(long id, int height, int width, Material material) {
		this.id = id;
		this.height = height;
		this.width = width;
		this.material = material;
	}

	public Opening(Opening a) {
		this.id = a.id;
		this.height = a.height;
		this.width = a.width;
		this.material = a.material;
	}

	public abstract long getId();

	public abstract void setId(long id);

	public abstract int getHeight();

	public abstract void setHeight(int height);

	public abstract int getWidth();

	public abstract void setWidth(int width);

	public abstract Material getMaterial();

	public abstract void setMaterial(Material material);

	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Id= ");
		sb.append(id);
		sb.append(" Alto= ");
		sb.append(height);
		sb.append(" Ancho= ");
		sb.append(width);
		sb.append(" Material= ");
		sb.append(material.toString());
		return sb.toString();
	}

}
