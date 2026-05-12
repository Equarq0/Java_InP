import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        List<String> treasures = new ArrayList<>();
        MyTreasures myTreasures = new MyTreasures(treasures);
        List<Thread> myThreads = new ArrayList<>(Arrays.asList(new Thread(myTreasures), new Thread(myTreasures)));
        for (Thread thread: myThreads) thread.start();
        for (Thread thread: myThreads) thread.join();
        System.out.println(treasures.size());
    }
}
