package com.book.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTests {

    ValidateISBN validateISBN;

    @Before
    public void setup() {

        validateISBN = new ValidateISBN();
    }

    @Test
    public void checkValidISBN() {

        boolean result = validateISBN.checkISBN("0140449116");
        assertTrue(result);
    }

    @Test
    public void checkInvalidISBN() {

        boolean result = validateISBN.checkISBN("0140441927");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void checkISBNLengthTenOrThirteen() {

        validateISBN.checkISBN("012345678");
    }

    @Test(expected = NumberFormatException.class)
    public void checkISBNNumeric() {

        validateISBN.checkISBN("helloworld");
    }

    @Test
    public void checkContainsX() {

        boolean result = validateISBN.checkISBN("080442957X");
        assertTrue(result);
    }

    @Test
    public void checkValidThirteenDigitISBN() {

        boolean result = validateISBN.checkISBN("9780306406157");
        assertTrue(result);
    }
}
