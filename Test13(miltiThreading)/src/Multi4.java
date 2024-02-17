public class Multi4 extends Thread{
    @Override
    public void run() {
        System.out.println("Runnable thread is running");
    }

    public static void main(String[] args){
        Multi4 m = new Multi4();
        m.start();
        m.start();
    }
}
