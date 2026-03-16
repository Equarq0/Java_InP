import java.util.Objects;

public class Visitor {
    String name;
    String passId;

    public Visitor(String name, String passId) {
        this.name = name;
        this.passId = passId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(passId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return Objects.equals(passId, visitor.passId);
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }


}
