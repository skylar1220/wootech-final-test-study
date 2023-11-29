import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {

    public static void main(String[] args) {
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
    }

}
