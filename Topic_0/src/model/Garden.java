package model;

public class Garden {

	private boolean fence;
	private boolean gardenGnome;
	private int plantAmount;

	public Garden() {
		fence = false;
		gardenGnome = false;
		plantAmount = 0;
	}

	public Garden(boolean fence, boolean gardenGnome, int plantAmount) {
		this.fence = fence;
		this.gardenGnome = gardenGnome;
		this.plantAmount = plantAmount;
	}

	public Garden(Garden g) {
		this.fence = g.fence;
		this.gardenGnome = g.gardenGnome;
		this.plantAmount = g.plantAmount;
	}

	public boolean isFence() {
		return fence;
	}

	public void setFence(boolean fence) {
		this.fence = fence;
	}

	public boolean isGardenGnome() {
		return gardenGnome;
	}

	public void setGardenGnome(boolean gardenGnome) {
		this.gardenGnome = gardenGnome;
	}

	public int getPlantAmount() {
		return plantAmount;
	}

	public void setPlantAmount(int plantAmount) {
		this.plantAmount = plantAmount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reja perimetral= ");
		builder.append(fence);
		builder.append(" Enano de Jardín= ");
		builder.append(gardenGnome);
		builder.append(" Cantidad de Plantas= ");
		builder.append(plantAmount);
		builder.append("\n");
		return builder.toString();
	}

}
