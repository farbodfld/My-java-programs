public class TestDemonThread extends Thread{

    public void run(){
        if (Thread.currentThread().isDaemon()){
            System.out.println("demon thread is working");
        }else {
            System.out.println("user thread is working");
        }
    }

    public static void main(String[] args){
        TestDemonThread m = new TestDemonThread();
        TestDemonThread m2 = new TestDemonThread();
        TestDemonThread m3 = new TestDemonThread();

        m.setDaemon(true);

        m.start();
        m2.start();
        m3.start();
    }
}
