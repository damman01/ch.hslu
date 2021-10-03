package ch.hslu.ad.sw01;

import java.util.Comparator;
import java.util.Objects;

public final class Allocation implements Comparable<Allocation> {

    private final long address;
    private final long size;

    public Allocation(final long address, final long size) {
        this.address = address;
        this.size = size;
    }

    public long getAddress() {
        return address;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("Allocation [address=%s, size=%s]", address, size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, size);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Allocation other = (Allocation) obj;
        return Objects.equals(address, other.getAddress()) && Objects.equals(size, other.getSize());
    }

    @Override
    public int compareTo(Allocation other) {
        return Comparator.comparingLong(Allocation::getAddress).thenComparingLong(Allocation::getSize).reversed()
                .compare(this, other);
    }

}
