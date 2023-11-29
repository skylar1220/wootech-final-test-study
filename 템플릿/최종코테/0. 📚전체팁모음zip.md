
# 목차
- [Enum(+사용자 입력)](#Enum)
- [컬렉션 프레임워크 List, Set, Map](#컬렉션-프레임워크)
- [날짜,요일](#날짜-요일)
- [네이밍](#네이밍)
- [람다 Supplier,Function](#람다)
- [문자열 join](#문자열-결합)
- [팁들](#팁들)
- [스트림](#스트림)
- [정규식](#정규식)
- [상수모음](#상수모음)


# Enum
# Enum 클래스 관리
## enum의 선언 순서 의존 해결!
![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/ba158d59-0e25-49b1-8abf-5d10a5a66b96)

## Command 관리 (사용자가 입력한 옵션)
- from으로 받아서 일치 안하면 오류던지기

```java
public enum UserCommand {
    Optioni1("1"),
    Optioni2("2")

    private final String command;

    UserCommand(String command) {
        this.command = command;
    }

    public static UserCommand from(String command) {
        return Arrays.stream(MainOption.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력은 으로 해야합니다."));
    }
}
```


<br> 

-----

# 컬렉션 프레임워크
# 1.  List (ArrayList)
- 객체 저장 순서 O
```java
// 메서드
list.isEmpty()

// 객체 삭제
list.clear();
list.remove(1) // 인덱스 1 삭제
list.remove("현지") // 객체를 직접 지정해서 삭제
```

# 2. Set
- 객체 저장 순서 X
- 중복 허용하지 않음
- HashSet, LinkedHashSet, TreeSet
- 메소드 중 add, contains, isEmpty, size, clear, remove 모두 list와 동일
```java
Set<String> set = new HashSet<>();

// for문으로도 반복 가능
for(String str: set){ }
```

# 3. Map
- key, value로 구성된 MapPractice.Entry 객체를 저장하는 구조
- Entry: MapPractice 인터페이스 내부에 선언된 중첩 인터페이스
### 1) 순서보장 x: HashMap
### 2) 순서 보장 o : linkedHashMap
### 3) enum 전용, enum 선언 순서대로 : enumMap

```java
 // 선언
 Map<String, Integer> map = new HashMap<>();

 // 객체 추가
 map.put("현지", 168); 

 // 객체 검색
 map.containsKey("현지") // true
 map.containsValue(168) // true
 map.get("현지") // 168

 map.isEmpty();
 map.size();
 map.keySet(); // key를 set에 담아서 리턴

 map.clear();
 map.remove("현지");

 // entrySet() 메소드로 모든 MapPractice.Entry를 얻은 다음, 
 // getKey(), getValue() 메소드 사용
 Set<MapPractice.Entry<String, Integer>> entrySet = map.entrySet();
 for(Entry entry: map.entrySet()) {
   String key = entry.getKey();
   Integer value = entry.getValue();
 }
```
### getOrDefault : 초기화 없이 사용하고 싶을 때
- Map 초기화 없이 사용하고 싶을 때 (value가 없는 키의 경우 value에 0 넣어줌)
- `map.put(key, map.getOrDefault(key, 0) +1 )`
```java
    private Map<Rank, Integer> countPrizes(WinningCombo winningCombo) {
        Map<Rank, Integer> prizeSummary = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank rank = winningCombo.determinePrize(lotto);
            prizeSummary.put(rank, prizeSummary.getOrDefault(rank, 0) + 1);
        }
        return prizeSummary;
    }
```

### map 활용 With IntStream
```java
    private static Map<Integer, LottoNumber> initializeLottoNumbers() {
        Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

        IntStream.rangeClosed(1, 3)
                .forEach(number -> lottoNumbers.put(number, new LottoNumber(number)));
        return lottoNumbers;
    }
```

# 4. sort

## 1) List
```java
Collections.sort(List<T> list):
```
- 이 메서드는 Collections 유틸리티 클래스에 있는 정적 메서드로서, List 안의 요소들을 기본적으로 오름차순으로 정렬합니다.
- Comparable 인터페이스를 구현한 객체에 대해서만 작동합니다.

```java
Collections.sort(List<T> list, Comparator<? super T> comparator):
```
- Comparable 인터페이스를 구현하지 않은 객체에 대해서도 정렬을 수행할 수 있도록 Comparator를 지정할 수 있는 메서드입니다.
- 사용자가 정의한 기준에 따라 정렬하고자 할 때 유용합니다.

## 2) Arrays
```java
Arrays.sort(T[] arr):
```
- 배열을 오름차순으로 정렬합니다.
- Comparable 인터페이스를 구현한 객체에 대해서만 작동합니다.

```java
Arrays.sort(T[] arr, Comparator<? super T> comparator):
```
- Comparator를 사용하여 배열을 정렬합니다.
- Comparable 인터페이스를 구현하지 않은 객체에 대해서도 정렬을 수행할 수 있습니다.

## 3) Map은 sort 불가

<br>

----


# 날짜 요일
## LocalDate

## dayOfWeek
- 그 날짜가 어느 요일인지 추출

![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/c26fe5ba-08af-49a9-acf6-d0a1d2a93a20)
<img width="763" alt="image" src="https://github.com/skylar1220/wootech-final-test-study/assets/110809927/482820c6-7873-4d01-bb41-510ccc570a1c">

## dayOfMonth
- LocalDate 객체들을 갖고 getDayOfMonth 메소드를 쓰면 몇 일에 해당하는 숫자만 추출
<img width="972" alt="image" src="https://github.com/skylar1220/wootech-final-test-study/assets/110809927/995e6eaa-875c-4419-931b-23dd04773fd9">


<br>
-----

# 네이밍

## 컨트롤러 내 메서드 네이밍 컨벤션
- input에서 입력을 받아서 객체로 받아오는 메소드 : get
<img width="659" alt="image" src="https://github.com/skylar1220/wootech-final-test-study/assets/110809927/c474e9eb-4a7d-4716-8e6b-f7dcbd53d159">


- 컨트롤러를 통해 다른 메소드에서 받은 값으로 객체를 만들어오는 메소드 : create, generate
<img width="856" alt="image" src="https://github.com/skylar1220/wootech-final-test-study/assets/110809927/f734a06a-dba6-440b-9513-aea8394504d7">


- 출력 연결 메소드 : show (print는 outputView에서 쓰므로)
<img width="823" alt="image" src="https://github.com/skylar1220/wootech-final-test-study/assets/110809927/673f50a1-23e1-469b-a26d-a3879a2d29c5">


## Total은 이름끝에!
이름의 끝에 이런 수정자를 입력하는 것이 좋다.

#### 좋은 예
- revenue`Total`
- expense`Average`

#### 나쁜 예
- `total`Revenue

## 피할 네이밍
- manager, process, info 등
- boolean 메소드에서의 부정어 네이밍
     - 차라리, 메소드 이름을 구성한 것 + !
<br> 

-----

# 람다

```java

// 종류
Supplier<Integer> supplier = () -> (int) (Math.random() * 100) + 1;

Consumer<Integer> consumer = i -> System.out.print(i + ", ");

Predicate<Integer> predicate = i -> i % 2 == 0;

Function<Integer, Integer> function = i -> i / 10 * 10;


List<Integer> list = new ArrayList<>();

// supplier
for (int i = 0; i < 10; i++) {
    list.add(supplier.get());
}

// predicate & consumer
for (int i : list) {
    if (predicate.test(i)) {
        consumer.accept(i);
    }
}

// function
for (int i : list) {
    list.add(function.apply(i));
}
```

<br> 

-----

# 문자열-결합
## String.format
```java
 String.format("%d :%s개", "1등", 30);

// String.formateed
"%d는 %s개d입니다.".formatted("1등", 30);
```


## 줄바꿈 더하기 System.lineSeparator()
```java
String.format("%s개", 30);
    + System.lineSeparator()
```

## 문자열 더하기 StringBuilder.append
```java
new StringBuilder().
    .append(String.format("%s개", 30))
    .append(System.lineSeparator());
```

## StringJoiner
- delimeter, prefix, suffix를 한꺼번에 줄 수 있지만,
- 반복문 돌려야함
```java
StringJoiner sj = new StringJoiner(",", "[", "]");
String[] strArr = {"aaa", "bbb", "ccc"};

for (String s : strArr) {
    sj.add(s.toUpperCase());
}

// [AAA, BBB, CCC]
```
<br> 

-----

# 팁들
## 중복 검증

```java
// set 방식
Set.copyOf(list).size() != list.size();

// stream 방식
list.stream().anyMath()
```
## 줄바꿈 자바 기본 메소드
![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/e42d999c-280f-410e-b72f-4fd4e9056b18)


## 세 자리마다 쉼표 출력 (돈 format)
```java
String.format("%,d", 3000);  // 3,000
```

## List를 문자열로 합치기
```java
String s = String.join("", list);
```

## 타입 변환
- int → String
```java
String str = String.valueOf(intValue);
String str = intValue + "";
```

## 반올림
round()를 사용해야 하는데, 항상 소수점 첫째자리에서 반올림한 정수값(long)을 결과로 돌려준다
원하는 자리 수에서 반올림된 값을 얻기 위해선, 간단히 10의 n제곱으로 곱한 후 다시 곱한 수로 나눠준다
예) 90.7552를 소수점 둘째 자리까지 구하고 싶다 => 10**2를 곱하고 나눈다
주의) 정수형 간의 연산에서는 반올림이 이루어지지 않는다.
```java
1. 90.7552 * 100 = 9075.52
2. Math.round(9075.52) = 9076
3. 9076 / 100.0 = 90.76
```

## 퍼센트 구하기 
`totalAmount / price * 100 + 소수점 아래 둘째 자리에서 반올림`

## 소수점 자리수 출력!
- %f: 실수형 숫자 형식 설정
```java
// 소수점 아래 3자로 반올림하여 나타내라
System.out.println(String.format("%.3f", 123.45678));	// 123.456
```
- %d: 정수형 숫자 형식 설정
```java
// 빈자리값은 0으로 채워서 5자리로 나타내라
System.out.println(String.format("%05d", 123));	// 00123
```

## Random number 받아오기
```java
int num = (int) (Math.random() * n) + start;

// 주사위 번호 하나 뽑기
int num = (int) (Math.random() * 6) + 1;
// 로또 번호 하나 뽑기
int num = (int) (Math.random() * 45) + 1;
```

## 반복문 탈출: break, continue
- 공통점: 반복문을 break하며 if문 안에 넣어 사용하는 것이 일반적
- break는 당장 반복문을 탈출함
- continue는 현재 진행중인 루프의 아래를 실행하지 않지만 다시 증감식으로 올라가서 다음루프를 실행함


## 나누기 용어
![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/5293c2fe-697e-4661-b66e-6b8e629d005c)

## 메서드 순서
> static 변수
> 멤버변수
> 주생성자
> 부생성자
> public 메소드
> private 메소드
> static 메소드
> getter 
> hashcode, equals

## comparble @@
일급컬렉션을 돌아야한다면 comparable 상속받아 구현하면 됨!
![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/d6983cb2-2304-4d5c-9b7c-0008d4b45855)

![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/874f06d9-0173-44df-9a80-7b3e468b793d)
<br> 

-----

# 스트림
## filter
```java
private static Position fromNumber(int generatedNumber) {
    return Arrays.stream(Position.values())
            .filter(position -> position.generatedNumber == generatedNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 번호의 포지션은 없습니다."));
}
```
## 가장 큰 객체 한 개만 리턴
```java
    private int getMaxDistance() {
        return playerMoveGroup.stream()
                .map(PlayerMove::getDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("플레이어 이동현황이 비어있습니다"));
    }
```

## score를 점수 (value)에 따라 정렬 => 점수가 같으면 이름순 => 최대 5명

```java
return score.keySet().stream()
          .filter(element -> score.get(element) > 0)
          .sorted()
          .sorted((e1,e2)->score.get(e2).compareTo(score.get(e1)))
          .limit(5)
          .collect(Collectors.toList());
```

## Collectors로 평균 값 구하기

```java
List<Integer> list = Arrays.asList(1,2,3,4);
Double result = list.stream().collect(Collectors.averagingInt(v -> v*2));
System.out.println("Average: " + result);
```
<br> 

-----

# 정규식
## Pattern 상수화 시켜놓기 
```java
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    public static boolean isNumber(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
    }
```

## 숫자 검증 정규식
- 마이너스까지 포함하는 숫자 검증
`-?\\d+`
- 양수만 검증
`\\d+`


## 한글 검증 정규식
- 한글로만 이루어져있는지 검증
`[가-힣]+`

- 조합 검증 : 한글-숫자 형태의 문자열
`[가-힣]+-[0-9]+`

## 특정 패턴 속 추출
```java
    public static final Pattern INPUT_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static List<String> split(String input) {
        Matcher m = INPUT_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(COMMA + "|" + COLUMN + "|" + customDelimiter);
            return removeBlank(tokens);
        }
        return removeBlank(tokens);
    }
```

<br> 

-----

# 상수모음
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
