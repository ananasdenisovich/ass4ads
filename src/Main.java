import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Student Karima = new Student("Karima", 1);
        MyTestingClass test = new MyTestingClass(0);
        table.put(test, Karima);
        System.out.println( table.contains(Karima));
        Random rand = new Random();
        for (int i = 0; i < 10000; i++){
            MyTestingClass key = new MyTestingClass(rand.nextInt(10000));
            Student value = new Student("studentName", i);
            table.put(key, value);
        }

    }
}