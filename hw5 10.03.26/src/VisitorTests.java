import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisitorTests {
    private MyHashSet<Visitor> VisitorsSet;

    @BeforeEach
    void setUp() {
        VisitorsSet = new MyHashSet<>();
    }

    @Test
    void testTest() {
        Visitor visitor = new Visitor("Василий", "123");
        VisitorsSet.add(visitor);
        Assertions.assertTrue(VisitorsSet.contains(visitor));
        visitor.setPassId("999");
        Assertions.assertFalse(VisitorsSet.contains(visitor));
        // False потому что мы клали Василия с 123 и хешкод вычислялся по 123, а теперь хешкод вычисляется по 999 а он другой соотв не находит
    }

}
