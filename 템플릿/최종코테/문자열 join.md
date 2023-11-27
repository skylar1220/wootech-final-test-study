## String.format
```java
 String.format("%d :%s개", "1등", 30);
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
