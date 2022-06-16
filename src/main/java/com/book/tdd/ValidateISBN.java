package com.book.tdd;

public class ValidateISBN {

    public static final int ISBN_SHORT = 10;
    public static final int ISBN_LONG = 13;
    public static final int ISBN_SHORT_VALIDATOR = 11;
    public static final int ISBN_LONG_VALIDATOR = 10;

    public boolean checkISBN(String isbn) {

        if (isbn.length() == ISBN_SHORT || isbn.length() == ISBN_LONG) {
            if (isbn.length() == ISBN_LONG) {
                return checkISBNThirteenDigits(isbn);
            } else {
                return checkISBNTenDigits(isbn);
            }
        } else {
            throw new NumberFormatException("ISBN number should have length of 10 or 13");
        }
    }

    private boolean checkISBNTenDigits(String isbn) {

        int total = 0;
        for (int i = 0; i < ISBN_SHORT; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN numbers can only have digits.");
                }
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * (ISBN_SHORT - i);
            }
        }
        if (total % ISBN_SHORT_VALIDATOR == 0) {
            return true;
        }
        return false;
    }

    private boolean checkISBNThirteenDigits(String isbn) {

        int total = 0;
        for (int i = 0; i < ISBN_LONG; i++) {
            if (Character.isDigit(isbn.charAt(i))) {
                if (i % 2 == 0) {
                    total += Character.getNumericValue(isbn.charAt(i)) * 1;
                } else {
                    total += Character.getNumericValue(isbn.charAt(i)) * 3;
                }
            } else {
                throw new NumberFormatException("ISBN numbers can only have digits.");
            }
        }
        if (total % ISBN_LONG_VALIDATOR == 0) {
            return true;
        }
        return false;
    }
}