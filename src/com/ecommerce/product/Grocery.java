package com.ecommerce.product;

import java.math.BigDecimal;

public class Grocery extends Product implements DeliveryChargeCalculator {
    public Grocery(String name, Double weight, BigDecimal price) {
        super(name, weight, price);
    }

    @Override
    public BigDecimal getDeliveryCharge(Product product) {
        return Order.getInstance().getDeliveryCharge(product);
    }
}
