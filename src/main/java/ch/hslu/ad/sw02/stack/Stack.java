package ch.hslu.ad.sw02.stack;

/**
 * Ein Stack (FILO) hat nur einen Zugriffspunkt
 */
public interface Stack<T> {

    /**
     * returns and removes the last added element from the stack
     * 
     * @return last added element
     */
    public T pop();

    /**
     * adds the provided element to the stack
     * 
     * @param element to be added
     */
    public void push(T element);

    /**
     * @return size of the stack
     */
    public int size();

}
