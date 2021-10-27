package ch.hslu.ad.sw03;

public interface Tree<T> {

    /**
     * Add new elemeent
     * 
     * @param elemenT element to be added
     */
    public void add(T elemenT);

    /**
     * Remove the element
     * 
     * @param elementT element to be removed
     */
    public void remove(T elementT);

}
