# Function apply 예시
<img width="601" alt="image" src="https://github.com/skylar1220/wootech-final-test-study/assets/110809927/d059cc43-09fe-4728-9d1d-c0a618782010">

# BiFunction 
![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/3d0ae47e-0b89-462f-a1a9-22ec97789040)
또는
더 복잡해지면
![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/8c41b3d4-f2b7-4fd1-917f-0af6d1028ace)
![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/8f9d9234-6f12-4e87-a5c7-4e094d4c8acf)


# 종류
````java

// 1. supplier
Supplier<Integer> supplier = () -> (int) (Math.random() * 100) + 1;

// 2. consumer
Consumer<Integer> consumer = i -> System.out.print(i + ", ");

// 3. predicate
Predicate<Integer> predicate = i -> i % 2 == 0;

// 4. function
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

