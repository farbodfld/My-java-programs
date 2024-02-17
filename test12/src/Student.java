import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Student implements Comparable<Student>{
    int s_id;

    public Student(int i){
        this.s_id = i;
    }

    @Override
    public String toString(){
        return s_id + " ";
    }

    @Override
    public int compareTo(Student s) {
        return (s_id - s.s_id);
    }
}

class Test_treeSet{
    public static void main(String[] args){
        Set<Student> set = new TreeSet<>();

        Student s1 = new Student(987);
        Student s2 = new Student(654);
        Student s3 = new Student(321);

        set.add(s1);
        set.add(s2);
        set.add(s3);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}