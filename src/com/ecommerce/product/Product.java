package com.ecommerce.product;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private Double weight;

    Product(String name, Double weight, BigDecimal price) {
        this.setName(name);
        this.setWeight(weight);
        this.setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public static Product getInstance(int productKindNumber) {
        return switch (productKindNumber) {
            case 1 -> new Beauty("화장품", 1.0, BigDecimal.valueOf(14500));
            case 2 -> new Grocery("식료품", 3.56, BigDecimal.valueOf(20000));
            case 3 -> new LargeAppliance("가전제품", 15.25, BigDecimal.valueOf(150000));
            default -> new Product("", 0.0, BigDecimal.ZERO);
        };
    }
}