package com.ecommerce.constants;

import java.util.function.Function;

public enum MessagesConstants {
    INPUT_PRODUCT_KIND_NUMBER("""
             
            %s할 상품을 번호를 입력 하세요.
            1. 화장품
            2. 식료품
            3. 가전제품
            """::formatted),
    WHETHER_CART_ADD_PRODUCT(value -> """
            
            다른 상품들도 추가적으로 구매하시겠습니까?
            1. Yes
            2. No
            """),
    CART_ADD_COMPLETION("""
            선택한 %s이 장바구니에 상품이 추가되었습니다.
            """::formatted);

    private final Function<String, String> expression;

    private MessagesConstants(Function expression) {
        this.expression = expression;
    }

    public String makeMessage(String value) {
        return (String)this.expression.apply(value);
    }

}
