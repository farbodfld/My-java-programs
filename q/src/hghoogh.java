import java.util.Scanner;

public class hghoogh {
    Scanner input = new Scanner(System.in);
    int hghoogh = 10000;
    int income;
    boolean accountants = false;
    boolean salesmen = false;
    boolean laborers = false;
    public void morakhasi(){
        System.out.println("who ar you ?");
        String awnser2 = input.nextLine();
        System.out.println("morkhasit pezeshkie ?");
        String awnser = input.nextLine();
        if (awnser.contains("yes")){
            System.out.println("chand rooz ?");
            int n = input.nextInt();
            System.out.println("ok done");
        }
        else {
            System.out.println("ta 3 rooz ba hghooghe morkhasit!");
            int count = 0;
            while (true) {
                count++;
                if (awnser2.contains("accountants") && count>3) {
                        income = hghoogh*8/100;
                        accountants= true;
                        break;
                }else if (awnser2.contains("salesmen") && count>3) {
                    income = hghoogh*5/100;
                    salesmen = true;
                    break;
                }else  if (awnser2.contains("laborers") && count>3) {
                    income = hghoogh*5/100;
                    laborers = true;
                    break;
                }
            }
        }
    }
    public void ismorkhasi(){
        if (!accountants){
            System.out.println("accountants is off!");
        }else if (!salesmen){
            System.out.println("salesmen is off!");
        }else if (!laborers){
            System.out.println("laborers is off!");
        }
    }
}
class accountants extends hghoogh{
    Scanner input = new Scanner(System.in);
    int id;
    String hamkar;
    public accountants(){
        id = (int) (Math.random()*10);
        System.out.println("your id is !" + id);
        income = hghoogh*40/100;
        System.out.println("your income is !" + income);
    }

}
class salesmen extends hghoogh{
    Scanner input = new Scanner(System.in);
    int id;
    String hamkar;
    public salesmen(){
        id = (int) (Math.random()*10);
        System.out.println("your id is !" + id);
        income = hghoogh*20/100;
        System.out.println("your income is !" + income);
    }
}
class laborers extends hghoogh{
    Scanner input = new Scanner(System.in);
    int id;
    String hamkar;
    public laborers(){
        id = (int) (Math.random()*10);
        System.out.println("your id is !" + id);
        income = hghoogh;
        System.out.println("your income is !" + income);
    }
}

class Test{
    public static void main(String[] args){
        accountants a = new accountants();
        salesmen s = new salesmen();
        laborers l = new laborers();
        a.morakhasi();
        a.ismorkhasi();

        s.morakhasi();
        s.ismorkhasi();

        l.morakhasi();
        l.ismorkhasi();

    }
}
