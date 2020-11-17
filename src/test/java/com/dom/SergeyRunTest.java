package com.dom;

import static org.junit.jupiter.api.Assertions.*;

class SergeyRunTest {

    @org.junit.jupiter.api.Test
    void testAddPositiveCase() {
        SergeyRun sr = new SergeyRun();
        assertEquals(8, sr.add(3, 5));
        System.out.println();
    }
    void testAddNegativeCase() {
        SergeyRun sr = new SergeyRun();
        assertNotEquals(9, sr.add(3, 4));
    }
}