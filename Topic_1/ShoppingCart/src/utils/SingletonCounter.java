package utils;

public class SingletonCounter {

	private static SingletonCounter singleton = null;
	private int counter = 1;

	private SingletonCounter() {
	}

	public static SingletonCounter getInstance() {
		synchronized (SingletonCounter.class) {
			if (singleton == null) {
				singleton = new SingletonCounter();
			}
		}
		return singleton;
	}

	public int nextId() {
		return counter++;
	}
}