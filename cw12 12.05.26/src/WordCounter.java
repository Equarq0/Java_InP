import java.util.ArrayList;
import java.util.List;

public class WordCounter {
    // Общая переменная для результата
    private static int totalCount = 0;

    public static void main(String[] args) throws InterruptedException {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            words.add("apple");
        }
        List<String> part1 = words.subList(0, 5000);
        List<String> part2 = words.subList(5000, 10000);
        Thread t1 = new Thread(() -> countWords(part1));
        Thread t2 = new Thread(() -> countWords(part2));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Total count: " + totalCount);
    }

    private static void countWords(List<String> list) {
        for (String word : list) {
            if (word.length() > 3) {
                synchronized (WordCounter.class) {
                    totalCount++;
                }
            }
        }
    }
}