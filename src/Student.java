import java.util.LinkedList;
import java.util.function.UnaryOperator;

public class Student extends LinkedList<Student> {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void replaceAll(UnaryOperator<Student> operator) {
        super.replaceAll(operator);
    }

    // Custom hashCode implementation
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}
