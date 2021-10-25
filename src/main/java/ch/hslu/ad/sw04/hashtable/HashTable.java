package ch.hslu.ad.sw04.hashtable;

public interface HashTable<E> {
    /**
     * Adds the given elemnt to HashTable
     * 
     * @param element Element to add
     * @return true if succesfully added
     */
    public boolean add(E element);

    /**
     * Removes the given element from HashTable
     * 
     * @param element Element to remove
     * @return true if succesfully removed
     */
    public boolean remove(E element);

    /**
     * Searches for the given element in the HashTable
     * 
     * @param element element to search for
     * @return true if element is found
     */
    public boolean contains(E element);

    /**
     * Checks if the HashTable is full
     * 
     * @return true if HashTable is full
     */
    public boolean isFull();

    /**
     * Checks the size of the HashTable
     * 
     * @return the size of the HashTable
     */
    public int size();

}
