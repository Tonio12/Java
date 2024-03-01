package com.tonio;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    private Utilities utility;
    @BeforeEach
    public void setUp(){
        utility = new Utilities();
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        assertArrayEquals(new char[]{'e','l'}, utility.everyNthChar(new char[]{'h','e','l','l','o'}, 2));
        assertArrayEquals(new char[]{'h','e','l','l','o'}, utility.everyNthChar(new char[]{'h','e','l','l','o'}, 10));
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        assertEquals("ABCDEF", utility.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", utility.removePairs("ABCCABDEEF"));
        assertNull(utility.removePairs(null));
    }

    @org.junit.jupiter.api.Test
    void converter() {
        assertEquals(300, utility.converter(10,5));
        assertThrows(ArithmeticException.class, ()-> utility.converter(10,0));
    }


    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        assertNull(utility.nullIfOddLength("hello"));
        assertEquals("Hi", utility.nullIfOddLength("Hi"));
    }
}