package ch.hslu.ad.sw02.queue;

public interface Queue<T> {

    public T show();

    public void add(T element);

    public T remove();
    
    public int index();
}
