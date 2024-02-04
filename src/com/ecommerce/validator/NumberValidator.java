package com.ecommerce.validator;

public class NumberValidator {
    private final int number;

    public int getNumber() {
        return this.number;
    }

    public NumberValidator(String inputNumber) {
        this.validateNumber(inputNumber);
        this.number = Integer.parseInt(inputNumber);
    }

    public void validateNumber(String number) {
        String regex = "[1-9]+";
        if (!number.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}