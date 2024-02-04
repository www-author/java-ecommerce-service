package com.ecommerce.constants;

import java.math.BigDecimal;

public enum WeightUnitBillingConstants {
    LESS_THAN_3KG(BigDecimal.valueOf(1000)),
    BETWEEN_3_AND_10KG(BigDecimal.valueOf(5000)),
    MORE_THAN_10KG(BigDecimal.valueOf(10000));

    private final BigDecimal weightUnitBilling;

    private WeightUnitBillingConstants(BigDecimal weightUnitBilling) {
        this.weightUnitBilling = weightUnitBilling;
    }

    public BigDecimal getWeightUnitBilling() {
        return this.weightUnitBilling;
    }
}
