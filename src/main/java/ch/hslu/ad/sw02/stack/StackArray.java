package ch.hslu.ad.sw02.stack;

public class StackArray implements Stack<String> {
    
    private final int limitSize;
    private final String[] stack;
    private int index;

    // Constructor
    public StackArray(int size) {
        this.limitSize  = size;
        this.stack = new String[size];
        index = -1;
    }


    @Override
    public String pop() {
        if (index < 0){
            throw new IllegalArgumentException("Stack ist leer");
        }
        return stack[index--];
    }

    @Override
    public void push(String element) {
        if (index + 1 >= limitSize){
            throw new IllegalArgumentException("Stack ist voll");
        }
        stack[++index] = element;
    }

    @Override
    public int size() {
        return index + 1;
    }

    public boolean isFull() {
        return size() >= limitSize;
    }

    public boolean isEmpty() {
        return size() <= 0;
    }
    

    
}
