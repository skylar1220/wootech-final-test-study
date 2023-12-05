````java
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

<img width="601" alt="image" src="https://github.com/skylar1220/wootech-final-test-study/assets/110809927/d059cc43-09fe-4728-9d1d-c0a618782010">
