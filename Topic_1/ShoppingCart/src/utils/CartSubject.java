package utils;

public interface CartSubject {

	public void addObserver(CartObserver cartObserver);

	public void removeObserver(CartObserver cartObserver);

	public void doNotify();

}
