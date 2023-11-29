# Constant (최대한 X)
- 최대한 클래스 내에서 해결
- 다양한 자료형의 상수가 모여있다면 Enum을 활용하기 어려움
- 한 클래스가 아니라 여러 클래스에서 사용되는 상수의 경우 따로 클래스를 만들자!
```java
public class Constants {

    public static final int NUMBER_COUNT = 6;
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    public static final int LOTTO_PRICE = 1000;

    private Constants() {
    }
}
```
