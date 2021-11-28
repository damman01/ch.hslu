package ch.hslu.ad.sw09;

import java.util.NoSuchElementException;

public class FixedIntegerHeap implements IntegerHeap {

    private int[] heap;
    private int nextFreeSlot = 0;

    public FixedIntegerHeap(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size must be positive and greater than 0");
        }
        heap = new int[size];
    }

    @Override
    public int getMax() {
        if (nextFreeSlot == 0) {
            throw new NoSuchElementException("no max value of empty heap");
        }
        // get max value
        int max = heap[0];

        // replace value to be returned
        if (--nextFreeSlot != 0) {
            heap[0] = heap[nextFreeSlot];
            // sink root element to proper position
            int currentIndex = 0;
            int leftChild = getLeftChildIndex(currentIndex);
            int rightChild = getRightChildIndex(currentIndex);
            while (rightChild <= nextFreeSlot
                    && (heap[currentIndex] < heap[rightChild] || heap[currentIndex] < heap[leftChild])) {
                if (heap[rightChild] > heap[leftChild]) {
                    swap(heap, currentIndex, rightChild);
                    currentIndex = rightChild;
                } else {
                    swap(heap, currentIndex, leftChild);
                    currentIndex = leftChild;
                }
                rightChild = getRightChildIndex(currentIndex);
                leftChild = getLeftChildIndex(currentIndex);
            }

        }
        return max;

    }

    private int getRightChildIndex(int parentIndex) {
        return (parentIndex + 1) * 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    int[] getHeap() {
        return heap;
    }

    int getSize() {
        return nextFreeSlot;
    }

    int get(int index) {
        return heap[index];
    }

    @Override
    public void insert(int element) {
        if (nextFreeSlot >= heap.length) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        // insert
        heap[nextFreeSlot] = element;
        int currentIndex = nextFreeSlot++;

        // rise to proper position
        for (int i = (currentIndex - 1) / 2; i >= 0 && heap[currentIndex] > heap[i]; i = (i - 1) / 2) {
            swap(heap, currentIndex, i);
            currentIndex = i;
        }
    }

    private void swap(final int[] a, final int firstIndex, final int secondIndex) {
        int tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

}
