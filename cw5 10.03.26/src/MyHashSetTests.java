import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyHashSetTests {
    private MyHashSet<String> myHashSet;

    @BeforeEach
    void setUp() {
        myHashSet = new MyHashSet<>();
    }

    @Test
    void testAdd() {
        Assertions.assertTrue(myHashSet.add("Java"));
        Assertions.assertTrue(myHashSet.add("Python"));
        Assertions.assertFalse(myHashSet.add("Java"));
        Assertions.assertEquals(2, myHashSet.size());
    }

    @Test
    void testContains() {
        myHashSet.add("Java");
        Assertions.assertTrue(myHashSet.contains("Java"));
        Assertions.assertFalse(myHashSet.contains("Rust"));
    }

    @Test
    void testRemove() {
        myHashSet.add("Java");
        Assertions.assertTrue(myHashSet.remove("Java"));
        Assertions.assertFalse(myHashSet.remove("Java"));
        Assertions.assertEquals(0, myHashSet.size());
    }

    @Test
    void testClearAndEmpty() {
        myHashSet.add("Java");
        myHashSet.add("Rust");
        Assertions.assertFalse(myHashSet.isEmpty());
        myHashSet.clear();
        Assertions.assertTrue(myHashSet.isEmpty());
        Assertions.assertEquals(0, myHashSet.size());
    }
}