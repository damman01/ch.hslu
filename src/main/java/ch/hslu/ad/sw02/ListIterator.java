package ch.hslu.ad.sw02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T> {

	Node<T> current;

	public ListIterator(List<T> list) {
		current = list.getHead();
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		T data = current.getData();
		current = current.getNext();
		return data;
	}

}
