package ch.hslu.ad.sw04.hashtable;

import ch.hslu.ad.sw01.Allocation;

public class AllocHashTable implements HashTable<Allocation> {

    private Allocation[] hashTable;
    private static final int MAX_SIZE = 10;
    private static final Allocation TOMBSTONE = new Allocation(-1, -1);
    private int size = 0;

    public AllocHashTable() {
        hashTable = new Allocation[MAX_SIZE];
    }

    private int getIndexofElement(Allocation element) {
        return (int) element.getAddress() % MAX_SIZE;
    }

    private void elementIsNotNull(Allocation element) {
        if (element == null) {
            throw new IllegalArgumentException("Element can't be NULL");
        }

    }

    private int getNextIndex(int currentIndex) {
        return (currentIndex + 1) % MAX_SIZE;
    }

    private int findIndexForElement(Allocation element) {
        int index = getIndexofElement(element);
        for (int i = index; i < index + MAX_SIZE; i++) {
            Allocation elementAtIndex = hashTable[index];
            if (elementAtIndex == null) {
                return -1;
            } else if (element.equals(elementAtIndex)) {
                return index;
            }
            index = getNextIndex(index);
        }
        return -1;
    }

    @Override
    public boolean add(Allocation element) {
        if (isFull()) {
            throw new IllegalStateException("Hashtable already full");
        }

        elementIsNotNull(element);

        int index = getIndexofElement(element);
        Allocation indexElement = hashTable[index];
        while (indexElement != null && !indexElement.equals(TOMBSTONE)) {
            if (element.equals(indexElement)) {
                return false;
            }
            index = getNextIndex(index);
            indexElement = hashTable[index];
        }
        hashTable[index] = element;
        size++;
        return true;
    }

    @Override
    public boolean remove(Allocation element) {

        elementIsNotNull(element);

        int index = findIndexForElement(element);
        if (index > -1) {
            hashTable[index] = TOMBSTONE;
            size--;
            return true;
        }
        return false;

    }

    @Override
    public boolean contains(Allocation element) {
        return !(element == null || findIndexForElement(element) <= -1);
    }

    @Override
    public boolean isFull() {
        return size() >= MAX_SIZE;
    }

    @Override
    public int size() {
        return size;
    }

}
