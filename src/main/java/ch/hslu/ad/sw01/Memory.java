package ch.hslu.ad.sw01;

public interface Memory {

    public Allocation allocate(long size);

    public void free(Allocation allocation);

    public long getCurrentSize();

    public long getFreeMemorySize();

}
