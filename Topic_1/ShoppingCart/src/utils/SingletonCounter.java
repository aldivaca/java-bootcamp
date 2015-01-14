package utils;

public class SingletonCounter {

	private static SingletonCounter singletonExample = null;
	private static int counter;

	private SingletonCounter() {
		counter = 1;
	}

	public static SingletonCounter getInstance() {
		if (singletonExample == null) {
			singletonExample = new SingletonCounter();
		} else {
			increment();
		}
		return singletonExample;
	}

	private static void increment() {
		counter++;
	}

	public int getNumber() {
		return counter;
	}
}