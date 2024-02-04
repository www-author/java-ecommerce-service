# [백엔드 개발자 오르미 4기] 2주차 과제 상속과 인터페이스 활용 
문제를 참고하여 아래 그림과 같은 클래스와 인터페이스를 생성하고, 기능을 구현하세요.

## 🚀 기능 요구 사항 

### 구현 범위 
1. 클래스와 인터페이스 선언, 각 메소드와 필드 선언
2. 그림에 나온 리턴 타입과 다른 리턴타입이어도 괜찮습니다. 
    - getDeliveryCharge() 메소드의 리턴타입은 double 혹은 int로 구현해도 OK
3. (Optional) 기능 세부 구현 
4. (Optional) BigDecimal 사용은 심화 버전 입니다. 참고자료를 보고 적용해봐도 괜찮습니다.

### 클래스 설계 및 기능 목록 

|기능 요구 목록|클래스 다이어그램|
|:---:|:---:|
|<img width="500" alt="기능목록.png" src="https://github.com/www-author/java-ecommerce-service/assets/148677085/4ca07420-87af-4aa3-aa3c-d8a9a6fce60c">|<img width="400" alt="클래스다이어그램.png" src="https://github.com/www-author/java-ecommerce-service/assets/148677085/8e13cb29-ca23-4d2e-b8df-b564f4ba94d8">|

## 🌱 참고 사항 

### 구현 예시 
- `Product` 클래스

```java
import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private Double weight;
}
```

- `DeliveryChargeCalculator` 인터페이스

```java
import java.math.BigDecimal;

public interface DeliveryChargeCalculator {
    BigDecimal getDeliveryCharge(Double weight, BigDecimal price);
}
```
### 🔗 참고 자료 
* BigDecomal 공식 자료 : https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html
* G-Market 공식 블로그 BigDecomal 가이드 : https://dev.gmarket.com/75
