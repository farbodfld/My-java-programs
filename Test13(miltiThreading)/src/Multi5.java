public class Multi5 extends Thread{
    @Override
    public void run() {
        System.out.println("Running");
    }

    public static void main(String[] args){
        Multi5 m = new Multi5();
        m.run();
    }
}
