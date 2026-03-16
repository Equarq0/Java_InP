import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClonesTests1 {
    private MyArrayList<Integer> my;
    private MyArrayList<Integer> added;

    @BeforeEach
    void setUp() {
        added = new MyArrayList<>();
        my = new MyArrayList<>();
        for (int i = 0; i < 100000; i++) {
            my.add(i);
        }
        my.add(98989);
    }

    @Test
    void containsTest() {
        long start = ((System.currentTimeMillis()));
        for (int i = 0; i < my.size(); i++) {
            Integer el = my.get(i);
            if (added.contains(el)) break;
            else added.add(el);
        }
        long end = ((System.currentTimeMillis()));
        System.out.println(end - start); // ~ 2100 - 2450
    }
// Так происходит потому что в хеш-сете мы ищем по хешу за константу
// (чутка замедлить могут коллизии только), а в contains у ArrayList в худшем случае за O(n) пробегаемся и сравниваем каждый элемент
}


