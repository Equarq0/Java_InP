import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class Task1 {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>(Arrays.asList("Admin", "Q", "Boba", "12"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() < 4) {
                iterator.remove();
            }
        }
        List<String> mylist = new ArrayList<>(Arrays.asList("Admin", "Boba"));
        Assertions.assertEquals(mylist, list);
    }

    @Test
    public void lambdaTest1() {
        List<String> list = new ArrayList<>(Arrays.asList("Admin", "Q", "Boba", "12"));
        list.removeIf(login -> login.length() < 4);
        list.forEach(login -> System.out.println(login));

    }
}
