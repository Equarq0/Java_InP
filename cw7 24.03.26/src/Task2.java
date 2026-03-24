import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Task2 {
    @Test
    public void Test1() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Laptop", 100000);
        hashMap.put("Phone", 25000);
        hashMap.put("Mouse", 3000);
        int discount = 15;
        hashMap.replaceAll((key, value) -> value * (100 - discount) / 100);
        hashMap.forEach((key, value) -> System.out.println(value));
    }
}
