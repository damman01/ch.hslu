package ch.hslu.ad.sw02.queue;

import java.util.Arrays;

public class QueueArray implements Queue<Character> {

    private static final int DEFAULT_ARRAY_INDEX = 8;
    private final Character[] queue;
    private final int maxindex;
    private int headIndex = 0;
    private int tailIndex = -1;
    private int index;

    public QueueArray(int index) {
        queue = new Character[index];
        this.maxindex = index;
    }

    public QueueArray() {
        this(DEFAULT_ARRAY_INDEX);
    }

    @Override
    public Character show() {
        if (isQueueEmpty()) {
            return null;
        }

        return queue[headIndex];
    }

    @Override
    public void add(Character element) {
        if (index() + 1 > maxindex) {
            throw new IllegalStateException("Queue is full, can't add another element");
        }
        tailIndex = getNewIndex(tailIndex);
        queue[tailIndex] = element;
        index++;
    }

    @Override
    public Character remove() {
        if (isQueueEmpty()) {
            throw new IllegalStateException("Queue is empty, nothing to remove");
        }
        index--;
        Character element = queue[headIndex];
        headIndex = getNewIndex(headIndex);

        return element;
    }

    private int getNewIndex(int index) {
        return index + 1 >= maxindex ? 0 : index + 1;
    }

    private boolean isQueueEmpty() {
        return index <= 0;
    }

    @Override
    public int index() {
        return index;
    }

    @Override
    public String toString() {
        return "QueueArray [headIndex=" + headIndex + ", index=" + index + ", maxindex=" + maxindex + ", queue="
                + Arrays.toString(queue) + ", tailIndex=" + tailIndex + "]";
    }

}
