import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MyHashMapTests {
    private MyHashMap<Integer, String> myHashMap;

    @BeforeEach
    void setUp() { myHashMap = new MyHashMap<>(); }

    @Test
    void testPutNGet() {
        myHashMap.put(54, "java(");
        myHashMap.put(32, "Python)");
        myHashMap.put(54, "HolyC)))");
        Assertions.assertEquals(myHashMap.get(54), "HolyC)))");
    }

    @Test
    void testRemove() {
        myHashMap.put(54, "java(");
        myHashMap.put(32, "Python)");
        myHashMap.remove(32);
        Assertions.assertEquals(myHashMap.get(32), null);
        Assertions.assertEquals(myHashMap.size(), 1);
    }

    @Test
    void testContainsKeyValue () {
        myHashMap.put(54, "java(");
        myHashMap.put(32, "Python)");
        myHashMap.put(21, "HolyC)))");
        Assertions.assertEquals(myHashMap.containsKey(54), true);
        Assertions.assertEquals(myHashMap.containsValue("Python)"), true);
    }

    @Test
    void testClearandEmpty() {
        myHashMap.put(54, "java(");
        myHashMap.put(32, "Python)");
        myHashMap.put(21, "HolyC)))");
        myHashMap.clear();
        Assertions.assertEquals(myHashMap.isEmpty(), true);
    }

    @Test
    void testResize() {
        myHashMap.put(54, "java(");
        myHashMap.put(32, "Python)");
        myHashMap.put(31, "java((");
        myHashMap.put(30, "Python))");
        myHashMap.put(29, "java(((");
        myHashMap.put(28, "Python)))");
        myHashMap.put(27, "java((((");
        myHashMap.put(26, "Python))))");
        myHashMap.put(25, "java(((((");
        myHashMap.put(24, "Python)))))");
        myHashMap.put(23, "java((((((");
        myHashMap.put(22, "Python))))))");
        myHashMap.put(21, "java(((((((");
        myHashMap.put(20, "Python))))))");
        myHashMap.put(19, "java(((((((");
        myHashMap.put(18, "Python))))))))");
        myHashMap.put(17, "java((((((((((");
        myHashMap.put(16, "Python)))))))))))");
        Assertions.assertEquals(myHashMap.size(), 18);
        Assertions.assertEquals(myHashMap.get(19), "java(((((((");
        Assertions.assertEquals(myHashMap.get(27), "java((((");
    }
}
