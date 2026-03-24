import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4<T> {
    List<Integer> filterList(List<Integer> list, Validator<Integer> validator) {
        List<Integer> result = new ArrayList<>();
        for (Integer el: list) {
            if (validator.check(el)) {
                result.add(el);
            }
        }
        return result;
    }

    @Test
    void Test1() {
        ArrayList<Integer> my = new ArrayList<>(Arrays.asList(1, -5, 10, -20, 33));

        List<Integer> fl  = filterList(my, value -> value > 0);

    }
}