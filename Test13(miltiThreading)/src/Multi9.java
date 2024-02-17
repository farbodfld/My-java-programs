public class Multi9 extends Thread{

    public void run(){
        System.out.println("task1");
    }
}

class Multi10 extends Thread{

    public void run(){
        System.out.println("task2");
    }
}

class Test{
    public static void main(String[] args){
        Multi9 m = new Multi9();
        Multi10 m2 = new Multi10();

        m.start();
        m2.start();
    }
}