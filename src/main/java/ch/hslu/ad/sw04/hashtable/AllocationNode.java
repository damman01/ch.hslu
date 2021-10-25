package ch.hslu.ad.sw04.hashtable;

import ch.hslu.ad.sw01.Allocation;
import ch.hslu.ad.sw02.Node;

public class AllocationNode extends Node<Allocation> {

    /**
     * @param data
     * @param next
     */
    public AllocationNode(Allocation data, AllocationNode next) {
        super(data, next);
    }

    /**
     * @param data
     */
    public AllocationNode(Allocation data) {
        super(data);
    }

}
