public class Multi1 extends Thread{

    public void run(){
        System.out.println("farbod's thread is running");
    }

    public static void main(String[] args){
        Multi1 m = new Multi1();
        Multi1 m2 = new Multi1();
        m.start();
        m2.start();
    }
}
