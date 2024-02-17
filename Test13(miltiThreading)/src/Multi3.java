public class Multi3 extends Thread{

    public void run(){
        for (int i = 1; i < 4; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args){
        Multi3 m = new Multi3();
        Multi3 m2 = new Multi3();

        m.start();
        m2.start();

        /*m.run();
        m2.run();    // khasiate thread boodn ro az dast mide!*/
       // m.start();
    }
}
