
# 1. Map
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
### getOrDefault : 초기화 하고 싶을 때
- Map 초기화하고 싶을 때 (value가 없는 키의 경우 value에 0 넣어줌)
```java
    private Map<Rank, Integer> initializePrizeSummary() {
        Map<Rank, Integer> prizeSummary = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            prizeSummary.put(rank, 0);
        }
        return prizeSummary;
    }
```
- (?) : `map.put(key, map.getOrDefault(key, 0) +1 )`
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
# 2. get : 빈자리에 0 안넣고 그냥 있는 것만 value 추가하는 버전
- Map 초기화 없이 사용하고 싶을 때 (value가 없는 키의 경우 value에 0 넣어줌)
- `map.put(key, map.get(key) +1 )`
```java
    private Map<Rank, Integer> countPrizes(WinningCombo winningCombo) {
        Map<Rank, Integer> prizeSummary = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank rank = winningCombo.determinePrize(lotto);
            prizeSummary.put(rank, prizeSummary.get(rank) + 1);
        }
        return prizeSummary;
    }
```

# 3. map 활용 With IntStream
```java
    private static Map<Integer, LottoNumber> initializeLottoNumbers() {
        Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

        IntStream.rangeClosed(1, 3)
                .forEach(number -> lottoNumbers.put(number, new LottoNumber(number)));
        return lottoNumbers;
    }
```
# 4.  Map 내부 요소별 갯수 확인하는 방식
<img width="806" alt="image" src="https://github.com/skylar1220/wootech-final-test-study/assets/110809927/42b90e39-de5c-483f-830a-52e3bc1f8164">
