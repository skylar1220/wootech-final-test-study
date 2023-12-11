## List['1,2', '3,4] 랑 다른 List['5,6',1,2']에 중복있는지 확인할 때
```java
public boolean containsSamePair(Pairs inputPairs) {
    return pairs.stream()
            .anyMatch(inputPairs::contains);
}

private boolean contains(Pair inputPair) {
    return pairs.stream()
            .anyMatch(pair -> pair.isSamePair(inputPair));
}
```

## filter
```java
private static Position fromNumber(int generatedNumber) {
    return Arrays.stream(Position.values())
            .filter(position -> position.generatedNumber == generatedNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 번호의 포지션은 없습니다."));
}
```

## 없는 stream generate해서 Optional 적용
```java
public void applyRecommandMenus(List<String> menus, MenusPicker menusPicker) {
    // 스트림으로 하면
    Stream.generate(() -> menusPicker.pick(menus))
            .filter(menu -> !isInvalidRecommand(menu))
            .findFirst()
            .ifPresent(weeklyMenus::add);

    // 풀면 원래 이 과정
    Optional<Menu> validMenu = Stream.generate(() -> menusPicker.pick(menus))
            .filter(menu -> !isInvalidRecommand(menu))
            .findFirst();

    validMenu.ifPresent(weeklyMenus::add);
}
```
## 가장 큰 객체 한 개만 리턴 1
```java
    private int getMaxDistance() {
        return playerMoveGroup.stream()
                .map(PlayerMove::getDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("플레이어 이동현황이 비어있습니다"));
    }
```

## 가장 큰 객체 한 개만 리턴 2

![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/0a34fb11-d37f-4a9f-91d7-2b4070d16e89)


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

## collectingAndThen
<img width="757" alt="image" src="https://github.com/skylar1220/wootech-final-test-study/assets/110809927/b470242c-9640-4896-8e46-f51ab171e2b9">
