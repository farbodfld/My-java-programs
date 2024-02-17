import java.util.Scanner;

public class Lift {

    private int floor;
    private int noPersons;
    private int capacity;


    public Lift(int f , int n , int c){
        this.floor = f;
        this.noPersons = n;
        this.capacity = c;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNoPersons() {
        return noPersons;
    }

    public void setNoPersons(int noPersons) {
        this.noPersons = noPersons;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public static class IllegalFloor extends Exception {
        public IllegalFloor(String a) {
            super(a);
        }
    }

    public static class IllegalLoad extends Exception {
        public IllegalLoad(String a) {
            super(a);
        }
    }
}

class Test{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Lift lift = new Lift(0,0,0);
        while (true){
            try {
                System.out.println("enter floor!");
                int f = in.nextInt();
                if (f > 50 || f < -50){
                    throw new Lift.IllegalFloor("floor Invalid!");
                }else {
                    lift.setFloor(f);
                }
                System.out.println("set capacity!");
                int c = in.nextInt();
                if (c > 450){
                    throw new Lift.IllegalLoad("!capacity exceeds Load");
                }else {
                    lift.setCapacity(c);
                    break;
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
