package ch.hslu.ad.sw02;

public class Node<E> {

	private E data;
	private Node<E> next;

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;

	}

	public Node(E data) {
		this(data, null);

	}

	public boolean hasNext() {
		return this.next != null;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

}
