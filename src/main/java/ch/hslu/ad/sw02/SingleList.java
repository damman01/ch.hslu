package ch.hslu.ad.sw02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleList<T> implements List<T> {

    private Node<T> head;
    private int size;

    public SingleList() {
        head = null;
        size = 0;
    }

    @Override
    public Node<T> getHead() {
        return head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Node<T> add(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        head = new Node<>(element, head);
        size++;
        return head;
    }

    @Override
    public void remove(T element) {
        if (head == null || element == null) {
            throw new NoSuchElementException("Zu löschende Elemente können nicht null sein!");
        }
        Node<T> currentNode = head;
        Node<T> nextElement = currentNode.getNext();

        if (element.equals(currentNode.getData())) {
            head = head.getNext();
            size--;
            return;
        }

        while (nextElement != null && !element.equals(nextElement.getData())) {
            currentNode = currentNode.getNext();
            nextElement = currentNode.getNext();
        }

        if (nextElement != null) {
            currentNode.setNext(nextElement.getNext());
            size--;
        } else {
            throw new NoSuchElementException();
        }

    }

    @Override
    public T pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T data = head.getData();
        head = head.getNext();
        size--;

        return data;
    }

    @Override
    public boolean exists(T element) {
        for (T item : this) {
            if (item.equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this);
    }

}
