import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class Task3 {
    @Test
    void func() {
        Function<Integer, Function<Integer, Integer>> curriedDiscount = percent -> price -> price - (price * percent / 100);
        Function<Integer, Integer> russianTax = curriedDiscount.apply(20);
        Function<Integer, Integer> usTax = curriedDiscount.apply(10);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(100, 500, 1000, 2000));
        list.forEach(value -> System.out.println("ru: " + russianTax.apply(value)));
        list.forEach(value -> System.out.println("us: " + usTax.apply(value)));



    }
}
