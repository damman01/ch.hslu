package ch.hslu.ad.sw02;


public interface List<T> extends Iterable<T>{

	public Node<T> getHead();

	public Node<T> getTail();

	public int size();

	public Node<T> add(T element);

	public void remove(T element);

	public T pop();

	public boolean exists(T element);

}
