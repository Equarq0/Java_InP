import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task5 {
    @Test
    void Test1() {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple"));
        Map<String, Integer> frequency = new HashMap<>();
        words.forEach(value -> frequency.merge(value, 1, Integer::sum));
        System.out.println(frequency);



    }
}
