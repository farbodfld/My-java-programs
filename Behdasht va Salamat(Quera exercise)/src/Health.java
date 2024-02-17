import java.util.Scanner;

public class Health {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        int examGrade, tripDays;
        examGrade = get.nextInt();
        tripDays = get.nextInt();

        if (tripDays == 0)
            System.out.println("20");
        else if (tripDays == 7)
            System.out.println(examGrade);
        else {
            while (tripDays > 0) {
                examGrade--;
                tripDays--;
            }
            if (examGrade < 0)
                System.out.println("0");
            else
                System.out.println(examGrade);
        }
    }
}
