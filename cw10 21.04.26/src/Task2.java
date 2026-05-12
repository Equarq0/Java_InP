import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.DoubleBuffer;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        String path = "D:/InP/cw10 21.04.26/src/numbers.txt";
        List<Double> nums = new ArrayList<>();
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(path);
            br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                String[] l = line.split(" ");
                for (String el: l) nums.add(Double.valueOf(el));
                line = br.readLine();
            }
            int count = nums.size();
            double sm = nums.stream().mapToDouble(p -> p).sum();
            double mn = nums.stream().mapToDouble(p -> p).min().orElse(0);
            double mx = nums.stream().mapToDouble(p -> p).max().orElse(0);
            double avg = sm / count;

            FileWriter fw = new FileWriter("stats.txt");
            fw.write("count=" + count + "\nsum=" + sm + "\nmin=" + mn + "\nmax=" + mx + "\navg=" + avg);
            fw.close();



        }
        catch (IOException e) {
            System.out.println("File not found");
        }

        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    System.out.println("Ошибка закрытия файла");
                }
            };
        }
    }
}
