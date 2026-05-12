import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTreasures implements Runnable {
    private final List<String> list = new ArrayList<>(Arrays.asList("Diamond", "Gold", "Silver"));
    List<String> treasuresList;

    public MyTreasures(List<String> treasuresList) {
        this.treasuresList = treasuresList;
    }
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 1000; i++) treasuresList.add(list.get(i % 3));
        }

        // Если уберу синхронайзд блок и оставлю просто:
        // for (int i = 0; i < 1000; i++) treasuresList.add(list.get(i % 3));
        // Тогда результаты будут розниться или выдавать исключение
    }
}
