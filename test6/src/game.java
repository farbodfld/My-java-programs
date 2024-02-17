import java.util.Scanner;

public class game {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("how mani charecter do you want!");
        int n = input.nextInt();
        animal[] list = new animal[n];

        System.out.println("how many rabbit do you want!");
        int m = input.nextInt();
        for (int i = 0; i < m; i++) {
            list[i] = new rabbit();
            for (int j = 0; j < m; j++) {
                if (list[j] instanceof rabbit){
                    rabbit r = (rabbit) list[j];
                }
                else if (list[j] instanceof wolf){
                    wolf w = (wolf) list[j];
                }
                else if (list[j] instanceof lion){
                    lion w = (lion) list[j];
                }
                else {
                    System.out.println("nothing found!");
                }
            }
        }

        System.out.println("how many wolf do you want!");
        int m2 = input.nextInt();
        for (int i = 0; i < m2; i++) {
            list[i] = new wolf();
            for (int j = 0; j < m2; j++) {
                if (list[j] instanceof rabbit){
                    rabbit r = (rabbit) list[j];
                }
                else if (list[j] instanceof wolf){
                    wolf w = (wolf) list[j];
                }
                else if (list[j] instanceof lion){
                    lion w = (lion) list[j];
                }
                else {
                    System.out.println("nothing found!");
                }
            }
        }

        System.out.println("how many lion do you want!");
        int m3 = input.nextInt();
        for (int i = 0; i < m3; i++) {
            list[i] = new lion();
            for (int j = 0; j < m3; j++) {
                if (list[j] instanceof rabbit){
                    rabbit r = (rabbit) list[j];
                }
                else if (list[j] instanceof wolf){
                    wolf w = (wolf) list[j];
                }
                else if (list[j] instanceof lion){
                    lion w = (lion) list[j];
                }
                else {
                    System.out.println("nothing found!");
                }
            }
        }
    }

}
class animal{
    public void move(){
        System.out.println("move!");
    }
    public void run(){
        System.out.println("run!");
    }
    public void eat(){
        System.out.println("eat!");
    }
}
class rabbit extends animal{
    public void move(){
        System.out.println("move rabbit!");
    }
}
class wolf extends animal{
    public void run(){
        System.out.println("run wolf!");
    }
}
class lion extends animal{
    public void eat(){
        System.out.println("eat lion!");
    }
}