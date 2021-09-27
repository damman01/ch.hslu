package ch.hslu.oop.sw06;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
   
    
    @Test
    public void testGetQuadrant1() {
        assertEquals(1, new Point(1, 1).getQuadrant());
    }
    
    @Test
    public void testGetQuadrant2() {
        assertEquals(2, new Point(-1, 1).getQuadrant());
    }
    
    @Test
    public void testGetQuadrant3() {
        assertEquals(3, new Point(-1, -1).getQuadrant());
    }
    
    @Test
    public void testGetQuadrant4() {
        assertEquals(4, new Point(1, -1).getQuadrant());
    }
}
