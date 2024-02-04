package com.ecommerce.product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private boolean isWhetherAddCart;
    private List<Product> products;

    public Cart() {
        this.isWhetherAddCart = true;
        this.products = new ArrayList<>();
    }

    public boolean isAddCart() {
        return this.isWhetherAddCart;
    }

    public void setWhetherAddCart(boolean isWhetherAddCart) {
        this.isWhetherAddCart = isWhetherAddCart;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void addCart(Product product) {
        this.products.add(product);
    }
}