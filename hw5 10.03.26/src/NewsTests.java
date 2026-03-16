import org.junit.jupiter.api.Test;

public class NewsTests {

    void generateFeed(MyList<String> list, int amount) {
        for (int i = 0; i < amount; i++) {
            list.add(0, "" + i);
        }
    }

    @Test
    void timeAddTest() {
        int amount = 100000;

        MyArrayList<String> arrayList = new MyArrayList<>();
        long start1 = System.currentTimeMillis();
        generateFeed(arrayList, amount);
        long end1 = System.currentTimeMillis();
        System.out.println((end1 - start1));

        MyDoubleLinkedList<String> linkedList = new MyDoubleLinkedList<>();
        long start2 = System.currentTimeMillis();
        generateFeed(linkedList, amount);
        long end2 = System.currentTimeMillis();
        System.out.println((end2 - start2));
    }
}