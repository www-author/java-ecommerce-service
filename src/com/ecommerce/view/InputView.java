package com.ecommerce.view;

import com.ecommerce.constants.MessagesConstants;
import com.ecommerce.utils.Console;
import com.ecommerce.validator.NumberValidator;

public class InputView {
    public int readProductKindNumber(String message) {
        System.out.println(MessagesConstants.INPUT_PRODUCT_KIND_NUMBER.makeMessage(message));
        return (new NumberValidator(Console.readLine().trim())).getNumber();
    }

    public boolean readWhetherAddCart() {
        System.out.println(MessagesConstants.WHETHER_CART_ADD_PRODUCT.makeMessage(""));
        int number = (new NumberValidator(Console.readLine().trim())).getNumber();
        return number == 1;
    }
}
