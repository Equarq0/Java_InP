import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws Exception {
        List<String> allLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:/InP/cw11 5.05.26/src/access.log"))) {
            String line;
            while ((line = br.readLine()) != null) {
                allLines.add(line);
            }
        }

        int threadsCount = 4;
        int chunkSize = allLines.size() / threadsCount;

        long startTime = System.currentTimeMillis();
        List<LogAnalyzer> analyzers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadsCount; i++) {
            int start = i * chunkSize;
            int end = (i == threadsCount - 1) ? allLines.size() : (i + 1) * chunkSize;

            LogAnalyzer analyzer = new LogAnalyzer(allLines.subList(start, end));
            Thread t = new Thread(analyzer);
            analyzers.add(analyzer);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) t.join();

        int errors = 0, apis = 0;
        for (LogAnalyzer a : analyzers) {
            errors += a.getErrorCount();
            apis += a.getApiUsersCount();
        }

        String result = "Errors: " + errors + ", API Users: " + apis + "Time: " + (System.currentTimeMillis() - startTime);

        System.out.println(result);

        try (PrintWriter pw = new PrintWriter(new FileWriter("result_1.txt"))) {
            pw.println(result);
        }
    }
}