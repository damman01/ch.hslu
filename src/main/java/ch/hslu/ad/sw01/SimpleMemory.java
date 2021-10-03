package ch.hslu.ad.sw01;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SimpleMemory implements Memory {

    private static final int DEFAULT_FIRST_ADDRESS = 0;
    private final long maxMemorySize;
    private long currentSize;
    private final long firstAddress;

    SortedSet<Allocation> memory = new TreeSet<>();
    SortedSet<Allocation> freedAllocations = new TreeSet<>(Comparator.comparing(Allocation::getSize).reversed());

    public SimpleMemory(long memorySize, long firstAddress) {
        this.maxMemorySize = memorySize;
        this.firstAddress = firstAddress;
        currentSize = 0;
    }

    public SimpleMemory(long memorySize) {
        this(memorySize, DEFAULT_FIRST_ADDRESS);
    }

    @Override
    public Allocation allocate(long size) {
        long address = getFreeFittingAddress(size);
        if (address + size > maxMemorySize) {
            throw new IllegalArgumentException("Can't allocate since it would exceed provided memory size");
        }
        Allocation allocation = new Allocation(address, size);
        memory.add(allocation);
        currentSize += size;
        return allocation;
    }

    @Override
    public void free(Allocation allocation) {
        if (!memory.contains(allocation)) {
            throw new IllegalArgumentException("Can't free memory since provided allocation is allocated");
        }

        memory.remove(allocation);
        freedAllocations.add(allocation);
        currentSize -= allocation.getSize();
    }

    @Override
    public long getCurrentSize() {
        return currentSize;
    }

    @Override
    public long getFreeMemorySize() {
        return maxMemorySize - getCurrentSize();
    }

    long getFreeFittingAddress(long size) {
        if (memory.isEmpty()) {
            return firstAddress;
        }

        // Fill Gaps
        if (!freedAllocations.isEmpty() && freedAllocations.first().getSize() >= size) {
            Allocation fittingAllocation = freedAllocations.first();
            freedAllocations.remove(fittingAllocation);
            return fittingAllocation.getAddress();
        }

        // no gap found, append to memory
        Allocation lastAllocation = memory.last();
        return lastAllocation.getAddress() + lastAllocation.getSize();
    }

    @Override
    public String toString() {
        return String.format("SimpleMemory [occupied=%s, free=%s]", getCurrentSize(), getFreeMemorySize());
    }

}
