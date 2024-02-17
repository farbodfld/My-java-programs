public class Multi2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable thread is running");
    }

    public static void main(String[] args){
        Multi2 m = new Multi2();
        Thread t = new Thread(m);
        t.start();
    }
}
