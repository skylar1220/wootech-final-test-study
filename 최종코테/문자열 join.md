## String.format
```java
 String.format("%d :%s개", "1등", 30);

// String.formateed
"%d는 %s개d입니다.".formatted("1등", 30);
```

## Collectors.joining
```java
Stream <String> wordsStream = Stream.of("1", "2", "3");
String result_delemiter             // 1-2-3
    = wordsStream.collect(Collectors.joining("-"));
String result_delemiter_pre_suffix  // [1-2-3]
    = wordsStream.collect(Collectors.joining("-, [, ]")); 
```
- joining(): 단순히 스트림의 문자열 요소를 연결한다.
- joining(CharSequence delimiter): 지정된 구분자를 사용하여 문자열을 결합한다.
- joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix): 구분자로 문자열을 연결하되, 결과 문자열의 시작과 끝에 접두어와 접미어를 추가한다.


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
