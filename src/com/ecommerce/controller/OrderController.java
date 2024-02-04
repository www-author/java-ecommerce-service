package com.ecommerce.controller;

import com.ecommerce.product.Cart;
import com.ecommerce.product.Order;
import com.ecommerce.product.Product;
import com.ecommerce.view.InputView;
import com.ecommerce.view.OutputView;
import java.util.List;

public class OrderController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private OrderController() {
    }

    public static OrderController getInstance() {
        return new OrderController();
    }

    public void start() {
        Cart cart = new Cart();
        int productKindNumber = 0;

        do {
            String message = productKindNumber == 0 ? "구매" : "추가";
            productKindNumber = this.inputView.readProductKindNumber(message);
            Product product = Product.getInstance(productKindNumber);
            cart.addCart(product);
            this.outputView.printCartAddProductCompletionMessage(product.getName());
            cart.setWhetherAddCart(this.inputView.readWhetherAddCart());
        } while(cart.isAddCart());

        List<Product> products = cart.getProducts();
        Order order = Order.from(products);
        this.outputView.printOrderList(order.makeOrderList(products));
    }
}
