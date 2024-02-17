public class Multi6 extends Thread {

    public void run() {
        for (int i = 1; i < 4; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Multi6 t1 = new Multi6();
        Multi6 t2 = new Multi6();
        Multi6 t3 = new Multi6();

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
        t3.start();
    }
}
