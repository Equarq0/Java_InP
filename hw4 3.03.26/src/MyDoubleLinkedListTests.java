import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MyDoubleLinkedListTests {
    private MyList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyDoubleLinkedList<>();
    }

    @Test
    void testAddAndSize() {
        list.add("Пирожок");
        list.add("Молоко");
        list.add(1, "Сахар");
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("Сахар", list.get(1));
    }

    @Test
    void testGet() {
        list.add("Пирожок");
        Assertions.assertEquals("Пирожок", list.get(0));
    }

    @Test
    void isEmptyTest() {
        Assertions.assertTrue(list.isEmpty());
        list.add("Пирожок");
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void testIndexRemove() {
        list.add("Пирожок");
        list.add("Молоко");
        Assertions.assertEquals(2, list.size());
        String removed = list.remove(1);
        Assertions.assertEquals("Молоко", removed);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void testElemRemove() {
        list.add("Пирожок");
        list.add("Молоко");
        Assertions.assertEquals(2, list.size());
        list.remove("Молоко");
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void testClear() {
        list.add("Пирожок");
        list.add("Молоко");
        Assertions.assertEquals(2, list.size());
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void testIndexOf() {
        list.add("Пирожок");
        list.add("Молоко");
        Assertions.assertEquals(0, list.indexOf("Пирожок"));
    }

    @Test
    void testContains() {
        list.add("Пирожок");
        list.add("Молоко");
        Assertions.assertTrue(list.contains("Пирожок"));
        Assertions.assertFalse(list.contains("Не пирожок"));
    }
}


    