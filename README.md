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
* BigDecomal 공식 자료 
 : https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html
* G-Market 공식 블로그 BigDecomal 가이드
 : https://dev.gmarket.com/75

## ♻️ 피드백 해줘 
### 나 개발자 '박지은'이 봤을 때 아쉬운점 👩🏻‍💻 
1. 컨트롤러에 비지니스 로직이 들어감

     ```안되지만 하다보니 들어가 버린게 반성스럽습니다.;; 내가 그때 왜 그랬을까? ```

2. 상수 클래스를 두었지만, 총 주문 결과 출력을 다른 곳에서 진행


3. 잘못된 과제의 요구사항 설계를 무리하게 적용하고자 함

4. 매직넘버가 아직 남아있다...! ```(반성하자 나 자신!)```

5. 정적 팩토리 메서드 패턴을 적용해보고 싶어서 어거지로 우겨넘

### 멘토님의 피드백! 
**개선 희망 부분**
> **비즈니스 로직의 분리(Service 부분)**
> * 과제의 설계 요구상으로는 어쩔 수 없이 Product에서 DeliveryChargeCalculator를 구현해야 하기 때문에 이부분은 논외
> * 기타 Order와 Cart 부분은 별도의 Service 로직으로 구성.

**폴더 기능 통합**
> * NumberValidaotr의 경우 Util에 통합하여 표기할 수도 있을 것으로 생각됨. <br>
> * Console의 경우는 꼭 필요한지 여부를 확인하는게 좋을 것으로 생각됨(input View에서만 사용되고, 기본 API를 대부분 사용하므로)

**흐름 및 Static 부분의 개선**
> * Product의 경우 Static보다는 Data로 생각해보면 요청이 있을때 생성해서 보내주고, Cart에서는 해당 데이터를 보관하는 방식으로 사용해도 괜찮을 것 같습니다.<br>
> * View에는 현재 판단이 되는 부분들은 Controller 또는 Cart에서 처리가 되면 좋을 것 같고 View에서는 사용자 입력에 따라서 Controller에서 앞으로 어떤 View를 표시해줄지만 들어가는 부분이 더 명확한 것 같습니다.

**구조적인 개선(패턴의 적용 방법)**
> * 일단 View 부분에서는 state패넡 같은 것으로 현재의 상태(입력값에 따라서) 주문단계, 추가주문단계, 출력단계 이런 식으로 표현하고 Input과 Output을 합쳐서 개선하는 것도 생각해볼 수 있을 것 같습니다.<br>
> * Contorller에서 Cart로 전달하고 Cart에 입려된 내용을 기반으로 다시 Order에 전달하는 방식으로 Mediator또는 Stretegy 패턴등을 활용해 볼 수 있을 것 같습니다.<br>
> * Product에는 Factory패턴 같을 적용할 수도 있을 것 같습니다.<br>
> * 전체적인 관점에서는 추가적인 패턴이나 다른 방식을 고려해볼 수 있기 때문에 Sequence Diagram을 통해 전체적인 흐름에 대해서 한번 고민해보고 접근해보는 것도 좋을 것 같습니다.
