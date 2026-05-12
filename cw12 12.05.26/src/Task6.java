import java.io.IOException;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task6 {
    private static int totalCount = 0;

    public static void main(String[] args) throws InterruptedException, IOException {
        List<String> words = new ArrayList<>(Files.readAllLines(Path.of("D:/InP/cw12 12.05.26/words.txt"))
                .stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(w -> !w.isEmpty())
                .toList());

        for (int i = 0; i < 10000; i++) {
            words.add("apple");
        }

        int mid = words.size() / 2;
        List<String> part1 = words.subList(0, mid);
        List<String> part2 = words.subList(mid, words.size());

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
                synchronized (Task6.class) {
                    totalCount++;
                }
            }
        }
    }
}