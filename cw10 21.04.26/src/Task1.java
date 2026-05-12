import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        String path = "D:/InP/cw10 21.04.26/src/students.csv";
        BufferedReader br = null;
        List<Student> student = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            br = new BufferedReader(fr);
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                String[] l = line.split(",");
                student.add(new Student((Integer.valueOf(l[0])), l[1], Integer.valueOf(l[2]), l[3]));
                line = br.readLine();

            }

            Map<String, Long> myMap = student.stream().collect(Collectors.groupingBy(g -> g.getGroup(), Collectors.counting()));
            System.out.println(myMap);
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