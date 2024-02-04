package com.ecommerce.view;

import com.ecommerce.constants.MessagesConstants;

public class OutputView {
    public OutputView() {
    }

    public void printCartAddProductCompletionMessage(String name) {
        System.out.println(MessagesConstants.CART_ADD_COMPLETION.makeMessage(name));
    }

    public void printOrderList(String message) {
        System.out.println(message);
    }
}