package com.ecommerce;

import com.ecommerce.controller.OrderController;

public class JavaEcommerceServiceApplication {
    public static void main(String[] args) {
        OrderController orderController = OrderController.getInstance();
        orderController.start();
    }
}
