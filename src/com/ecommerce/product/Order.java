package com.ecommerce.product;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import static com.ecommerce.constants.WeightUnitBillingConstants.*;


public class Order {
    private BigDecimal deliveryCharge;
    private BigDecimal productAmount;
    private BigDecimal totalOrderAmount;

    private Order() {}

    private Order(BigDecimal deliveryCharge, BigDecimal productAmount, BigDecimal totalOrderAmount) {
        this.deliveryCharge = deliveryCharge;
        this.productAmount = productAmount;
        this.totalOrderAmount = totalOrderAmount;
    }

    public static Order getInstance() {
        return new Order();
    }

    public static Order from(List<Product> products) {
        BigDecimal deliveryCharge = calculateDeliveryCharge(products);
        Stream<BigDecimal> bigDecimalStream = products.stream().map(Product::getPrice);
        BigDecimal productAmount = calculateProductPrice(bigDecimalStream);
        BigDecimal totalOrderAmount = deliveryCharge.add(productAmount);
        return new Order(deliveryCharge, productAmount, totalOrderAmount);
    }

    public BigDecimal getDeliveryCharge(Product product) {
        BigDecimal weightUnitBilling = getWeightUnitBilling(product.getWeight());
        return getBillingByPrice(product.getPrice(), weightUnitBilling);
    }

    public static BigDecimal calculateDeliveryCharge(List<Product> products) {
        BigDecimal deliveryCharge = BigDecimal.ZERO;

        for(Product product : products) {
            BigDecimal weightUnitBilling = getWeightUnitBilling(product.getWeight());
            deliveryCharge = deliveryCharge.add(getBillingByPrice(product.getPrice(), weightUnitBilling));
        }

        return deliveryCharge;
    }

    public static BigDecimal getWeightUnitBilling(Double weight) {
        if (weight < 3) {
            return LESS_THAN_3KG.getWeightUnitBilling();
        } else if (weight < 10) {
            return BETWEEN_3_AND_10KG.getWeightUnitBilling();
        }
        return MORE_THAN_10KG.getWeightUnitBilling();
    }

    public static BigDecimal getBillingByPrice(BigDecimal price, BigDecimal deliveryCharge) {
        if (price.compareTo(BigDecimal.valueOf(30000)) < 0) {
            return deliveryCharge;
        } else if (price.compareTo(BigDecimal.valueOf(100000)) < 0) {
            BigDecimal discountPrice = BigDecimal.valueOf(1000);
            return deliveryCharge.subtract(discountPrice);
        }
        return BigDecimal.ZERO;
    }

    public static BigDecimal calculateProductPrice(Stream<BigDecimal> productPrices) {
        return productPrices.reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String makeOrderList(List<Product> products) {
        String message = "";

        for(Product product : products) {
            message += """
                    
                    상품명 : %s
                    상품 가격 : %s
                    
                    """.formatted(product.getName(), product.getPrice());
        }

        return """
                [[주문금액]]
                %s
                --------------------------
                상품 금액 : %s
                배송비 : %s
                합계 : %s
                """.formatted(message, this.productAmount, this.deliveryCharge, this.totalOrderAmount);
    }
}
