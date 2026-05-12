import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        String sourcePath = "D:/InP/cw10 21.04.26/src/images.jpg";
        String destPath = "cat-copy.jpg";

        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {

            int c;
            while ((c = fis.read()) != -1) {
                fos.write(c);
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}