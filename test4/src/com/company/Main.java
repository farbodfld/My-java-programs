import java.util.Scanner;

public class Main {

    static void printarrey(int []arr){
        
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];
        int temp =0;
        int index=0;
        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random() * 11+10);
        }
        int[] arr2=new int[n];
        System.arraycopy(arr,0,arr2,0,arr.length);
        for (int ans:arr2) {
            System.out.println(ans);
        }
	// write your code here
    }
}
class student{
    private int id;
    private BirthDate birthdate;
    class BirthDate{
        private int year;
        private int month;
        private int day;
        BirthDate(int y , int m, int d){
            year = y;
            month = m;
            day = d;
        }
        void setYear(int y){
            year = y;
        }
    }
    student(int i, int y, int m, int d){
        id = i;
        birthdate = new BirthDate(y, m, d);
    }
    int getId(){
        return id;
    }
    BirthDate getBirthDate(){
        return birthdate;
    }
}
class test{
    static void Main(String[] args){
        student student = new student(111223333, 1970, 5, 3);
        student.BirthDate date = student.getBirthDate();
        date.setYear(2010);
    }
}
class student2{
    private int id;
    private String name;
    student2(int id , String name){
       this.id = id;
        this.name = name;
    }
    student2(int id){
        this(id, "no-name");
    }
}
class person{
    int id;
    String name;
    person(){
        System.out.println("no arg constactor is caled");
    }
    person(int id , String name){
        this();
        this.id = id;
        this.name = name;
    }
    void msg(){
        System.out.println(name + " "+ id);
    }
}
class test2{
    public static void main(String[] args){
        person p = new person(023265,"farbod");

    }
}