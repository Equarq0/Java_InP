import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        File outputFolder = new File("output");
        if (!outputFolder.exists()) {
            outputFolder.mkdir();
        }

        File inputFolder = new File("input");
        File[] txtFiles = inputFolder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles == null || txtFiles.length == 0) {
            return;
        }

        List<FileNormalizer> workers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (File file : txtFiles) {
            File outputFile = new File(outputFolder, file.getName());
            FileNormalizer worker = new FileNormalizer(file, outputFile);

            Thread thread = new Thread(worker);

            workers.add(worker);
            threads.add(thread);
            thread.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        int totalBefore = 0;
        int totalAfter = 0;
        for (FileNormalizer w : workers) {
            totalBefore += w.getLinesBefore();
            totalAfter += w.getLinesAfter();
        }

        String summary = "Обработано: " + txtFiles.length + " файлов. " + "Строк до: " + totalBefore + ", строк после: " + totalAfter;

        System.out.println(summary);

        try (PrintWriter resultWriter = new PrintWriter(new FileWriter("result_2.txt"))) {
            resultWriter.println(summary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
