# 컬렉션 프레임워크
# 1.  List (ArrayList)
- 객체 저장 순서 O
```java
List<Integer> list = new ArrayList<>(Arrays.asList(1, 3));

// 메서드
list.isEmpty()

// 객체 삭제
list.clear();
list.remove(1) // 인덱스 1 삭제
list.remove("현지") // 객체를 직접 지정해서 삭제

// 특정 인덱스에 요소 추가
list.add(1, 2);  // 1, '2', 3

// 특정 인덱스에 리스트 추가
List<Integer> newList = new ArrayList<>(Arrays.asList(20, 21));
list.addAll(1, newList);  // 1, '20', '21', 2, 3
```

### containAll : 순서 상관없이 포함 확인
```java
public boolean isSamePair(Pair inputPair) {
  return crews.containsAll(inputPair.crews);
}
```

## List.of, Arrays.asList -> 수정 불가!
- `List.of`
   - 완전한 불변 리스트: add, set, remove 에 대해서 모두 UnsupportedOerationException을 발생 
- `Arrays.asList`
   - 반만 불변: add, remove 는 같은 예외를 던지지만, set은 가능
- `Collections.unmodifiableList`
   - List.of처럼 불변 리스트지만, 원본배열을 참조하기 때문에 원본배열이 바뀌면 값이 바뀐다.



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


# 📌 sort

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



# 불변 리스트 변경 여부
https://alkhwa-113.tistory.com/entry/Listof-vs-ArraysasList-vs-CollectionsunmodifiableList

# Collections.frequency(list, 요소): 들어간 갯수 확인 가능!
<img width="677" alt="image" src="https://github.com/skylar1220/wootech-final-test-study/assets/110809927/1e9dd1f5-6c56-40c1-ae6d-527705ae8e6d">


