import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Student Karima = new Student("a", 1);
        MyTestingClass test = new MyTestingClass(0);
        Student notKarima = new Student("b", 2);
        table.put(test, Karima);
        System.out.print("Lets check if Karima is in table: ");
        System.out.println(table.contains(Karima));
        table.replace(test, Karima, notKarima);
        System.out.print("We applied replace method. Now lets check if notKarima is there: ");
        System.out.println(table.contains(notKarima));
    }
}