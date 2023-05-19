import java.util.Objects;

public class MyTestingClass {
    private int n;

    public MyTestingClass(int n) {
        this.n = n;
    }
    public int hashCode(){
        int result = 17;
        result = 31 * result + n;
        return result;
    }

}
