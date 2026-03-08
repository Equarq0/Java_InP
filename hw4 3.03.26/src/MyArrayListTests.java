import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyArrayListTests {
    private MyList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void testAddRemove() {
        // 1. Добавляем элементы: [4, 5, 7]
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(2, 6);
        int deleted = list.remove(0);
        boolean isDeleted = list.remove(Integer.valueOf(7));
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(5, list.get(0));
        Assertions.assertEquals(6, list.get(1));
        Assertions.assertTrue(isDeleted);
        Assertions.assertEquals(4, deleted);
    }

    @Test
    void testGet() {
        list.add(4);
        list.add(5);
        int item = list.get(0);
        Assertions.assertEquals(4, item);
    }

    @Test
    void testSize() {
        list.add(4);
        list.add(5);
        int size = list.size();
        Assertions.assertEquals(2, size);
    }

    @Test
    void testEmpty() {
        Assertions.assertEquals(true, list.isEmpty());
        list.add(4);
        Assertions.assertEquals(false, list.isEmpty());
    }

    @Test
    void testClear() {
        list.add(5);
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void testContains() {
        Assertions.assertFalse(list.contains(3));
        list.add(3);
        Assertions.assertTrue(list.contains(3));
    }

    @Test
    void testIndexOf() {
        list.add(4);
        list.add(5);
        list.add(6);
        Assertions.assertEquals(1, list.indexOf(5));
    }
}