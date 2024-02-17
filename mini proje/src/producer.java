import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class tolidkonande {
    static public int sood = 0;
    static int counter = 0;
    static List<String> list = new ArrayList<>();
    static List<Long> passlist = new ArrayList<Long>();
    static tolidkonande[] lst = new tolidkonande[100];
    static String[] listeuserandpass = new String[100];
    static ArrayList<String> listetk = new ArrayList<>();
    static List<String> listekalaha = new ArrayList<String>();
    static List<String> listekalaha2 = new ArrayList<String>();
    static List<String> listekalaha3 = new ArrayList<String>();
    static public String user;
    static public long pass;

    public tolidkonande() {
        user = admin.gettkUsername();
        pass = admin.gettkPassword();
    }

    static int i = 0;

    public void addtolidkonande() {
        lst[i] = new tolidkonande();
        i++;
    }

    public static void enteruserandpass() {
        Scanner input = new Scanner(System.in);
        System.out.println("enter your username");
        String a = input.nextLine();
        System.out.println("enter your password");
        int b = input.nextInt();
        if (a.contains(user) && b == pass) {
            System.out.println("wellcome");
        } else {
            System.out.println("invalid username or password");
            System.out.println("please try again");
            enteruserandpass();
        }
        listetk.add(admin.gettkUsername());
        passlist.add(admin.gettkPassword());
    }

    public static void ezafekardankala() {
        Scanner input = new Scanner(System.in);
        // byad ye if beznim ke chek kone aya item barabare kala hast ya na
        // be tedade kala ha if lazem darim
        System.out.println("please enter your count");
        int number = input.nextInt();
        // list = new String[number];
        System.out.println("please enter your item's category");
        input.nextLine();
        String item = input.nextLine();
        if (item.contains("tanagholat") || item.contains("labaniat") || item.contains("mivevasabzijat")) {
            for (int i = 0; i < number; i++) {
                listekalaha.add(item);
                counter++;
            }
            System.out.println("your new list will be:");
            for (int j = 0; j < listekalaha.size(); j++) {
                System.out.println(listekalaha.get(i) + " ");
            }
        } else if (item.contains("shalvar") || item.contains("pirahan") || item.contains("kafsh")) {
            for (int i = 0; i < number; i++) {
                listekalaha2.add(item);
                counter++;
            }
            System.out.println("your new list will be:");
            for (int j = 0; j < listekalaha2.size(); j++) {
                System.out.println(listekalaha2.get(i) + " ");
            }
        } else if (item.contains("television") || item.contains("telefonehamrah") || item.contains("consolebazi")) {
            for (int i = 0; i < number; i++) {
                listekalaha3.add(item);
                counter++;
            }
            System.out.println("your new list will be:");
            for (int j = 0; j < listekalaha3.size(); j++) {
                System.out.println(listekalaha3.get(i) + " ");
            }
        }
    }

    public static void hazfkardankala() {
        Scanner input = new Scanner(System.in);
        // byad ye if beznim ke chek kone aya item barabare kala hast ya na
        // be tedade kala ha if lazem darim
        System.out.println("please enter your count");
        int number = input.nextInt();
        //list = new String[number];
        System.out.println("please enter your item's category and item's number");
        String item = input.next();
        int adad = input.nextInt();
        if (item.contains("tanagholat") || item.contains("labaniat") || item.contains("mivevasabzijat")) {
            for (int i = 0; i < number; i++) {
                listekalaha.remove(adad);
                counter--;
            }
            System.out.println("your new list will be:");
            for (int j = 0; j < listekalaha.size(); j++) {
                System.out.println(listekalaha.get(i) + " ");
            }
        } else if (item.contains("shalvar") || item.contains("pirahan") || item.contains("kafsh")) {
            for (int i = 0; i < number; i++) {
                listekalaha2.remove(adad);
                counter--;
            }
            System.out.println("your new list will be:");
            for (int j = 0; j < listekalaha2.size(); j++) {
                System.out.println(listekalaha2.get(i) + " ");
            }
        } else if (item.contains("television") || item.contains("telefonehamrah") || item.contains("consolebazi")) {
            for (int i = 0; i < number; i++) {
                listekalaha3.remove(adad);
                counter--;
            }
            System.out.println("your new list will be:");
            for (int j = 0; j < listekalaha3.size(); j++) {
                System.out.println(listekalaha3.get(i) + " ");
            }
        }
    }

    public static void discount() {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter your item");
        String kala = input.nextLine();

        System.out.println("please enter your discount amount");
        int amount = input.nextInt();
       /* if (kala.contains(goods.name)) {
            goods.price = goods.price * amount / 100;
        } else {
            System.out.println("invalid item");
        }  */

        if (kala.contains("tanagholat") || kala.contains("labaniat") || kala.contains("mivevasabzijat")) {
            /*aghlamvaajnas.*/
            khoraki.price -= amount;
        } else if (kala.contains("shalvar") || kala.contains("pirahan") || kala.contains("kafsh")) {
            /*aghlamvaajnas.*/
            pooshak.price -= amount;
        } else if (kala.contains("television") || kala.contains("telefonehamrah") || kala.contains("consolebazi")) {
            /*aghlamvaajnas.*/
            lavazemelctrici.price -= amount;
        }
    }

    public static void tolidajnas() {
        System.out.println("please enter your product's category you want to make");
        Scanner input = new Scanner(System.in);
        String product = input.nextLine();
        if (product.contains("tanagholat") || product.contains("labaniat") || product.contains("mivevasabzijat")) {
            khoraki k = new khoraki();
            listekalaha.add(khoraki.getname());
        } else if (product.contains("shalvar") || product.contains("pirahan") || product.contains("kafsh")) {
            pooshak p = new pooshak();
            listekalaha2.add(pooshak.getname());
        } else if (product.contains("television") || product.contains("telefonehamrah") || product.contains("consolebazi")) {
            lavazemelctrici l = new lavazemelctrici();
            listekalaha3.add(lavazemelctrici.getname());
        }
    }

    public static int getSood() {
        return sood;
    }

    /**************************/

    public static void makenewproduct() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name of product");
        String pr_name = input.next();
        System.out.println("Enter size of your product");
        double size = input.nextDouble();
        System.out.println("Enter price of product");
        double price = input.nextDouble();
        String Manufacturer = user;

        // goods x=new goods(price,size,pr_name,Manufacturer);
        System.out.println("Enter type of this product :\n if is Electronis Enter : elec \n if is food Enter : food \nif is Apparel Enter :apr");
        String naghi = input.next();
        if (naghi.equals("elec")) {
            System.out.println("Enter years of make");
            int a = input.nextInt();
            Electeronics e = new Electeronics(price, size, pr_name, Manufacturer, a);
            listekalaha3.add(pr_name);
            System.out.println("Finished");
        } else if (naghi.equals("food")) {

            System.out.println("Enter Expired time");
            int expired = input.nextInt();
            foods f = new foods(price, size, pr_name, Manufacturer, expired);
            listekalaha.add(pr_name);

            System.out.println("Enter type of your foods : ");
            System.out.println("Enter dairy");
            System.out.println("Enter junk");
            System.out.println("Enter veg");

            String typeoffood = input.next();
            if (typeoffood.equals("junk")) {
                junkfoodordairy j = new junkfoodordairy(price, size, pr_name, Manufacturer, expired);
                listekalaha.add(pr_name);
                System.out.println("Finished");
            } else if (typeoffood.equals("veg")) {

                System.out.println("Enter city name that produced :(string)");
                String n = input.next();
                vegtebels v = new vegtebels(price, size, pr_name, Manufacturer, expired, n);
                listekalaha.add(pr_name);
                System.out.println("Finished");
            } else if (typeoffood.equals("dairy")) {
                junkfoodordairy da = new junkfoodordairy(price, size, pr_name, Manufacturer, expired);
                listekalaha.add(pr_name);
                System.out.println("Finished");
            }
        } else if (naghi.equals("apr")) {

            System.out.println("Enter Gender name");
            String gender = input.next();
            Apparel ap = new Apparel(price, size, pr_name, Manufacturer, gender);
            listekalaha3.add(pr_name);

            System.out.println("Enter type of Apparel\nEnter shirt\nEnter shoe\n Enter pants");
            String typeofApparel = input.next();

            if (typeofApparel.equals("shirt")) {

                System.out.println("Enter size of body between : S , M , L");
                String sizes = input.next();
                shirtorpants sh = new shirtorpants(price, size, pr_name, Manufacturer, gender, sizes);
                listekalaha3.add(pr_name);
                System.out.println("Finished");
            }
            if (typeofApparel.equals("shoe")) {

                System.out.println("Enter size of shoe");
                int sizeshoe = input.nextInt();
                shoe shoe1 = new shoe(price, size, pr_name, Manufacturer, gender, sizeshoe);
                listekalaha3.add(pr_name);
                System.out.println("Finished");
            }
            if (typeofApparel.equals("pants")) {

                System.out.println("Enter size body between : S , M , L");
                String sizes = input.next();
                shirtorpants pa = new shirtorpants(price, size, pr_name, Manufacturer, gender, sizes);
                listekalaha3.add(pr_name);
                System.out.println("Finished");
            }
        } else {
            System.out.println("invalid category ");
        }
    }

    /**************************/

}

/*******************************/
class goods {
    static double price;
    double size;
    String sherkatesazande;
    static String name;

    public goods(double p, double s, String n, String sh) {
        price = p;
        size = s;
        name = n;
        sherkatesazande = sh;
    }
}

class foods extends goods {

    int Expiredtime = 0;

    foods(double p, double s, String n, String sh, int ex) {
        super(p, s, n, sh);
        Expiredtime = ex;
    }
}

class vegtebels extends foods {
    String cityname;

    vegtebels(double p, double s, String n, String sh, int ex, String ci_name) {
        super(p, s, n, sh, ex);
        cityname = ci_name;
    }

}

class junkfoodordairy extends foods {
    junkfoodordairy(double p, double s, String n, String sh, int ex) {
        super(p, s, n, sh, ex);

    }

}

class Electeronics extends goods {
    int year_of_construction;

    Electeronics(double p, double s, String n, String sh, int construct) {
        super(p, s, n, sh);
        year_of_construction = construct;
    }
}

class Console extends Electeronics {
    String others;

    Console(double p, double s, String n, String sh, int construct, String others) {
        super(p, s, n, sh, construct);
        this.others = others;
    }

}

class TVorPhone extends Electeronics {
    int monitorsize;

    TVorPhone(double p, double s, String n, String sh, int construct, int Monitor) {
        super(p, s, n, sh, construct);
        monitorsize = Monitor;
    }
}

class Apparel extends goods {
    String Gender;

    Apparel(double p, double s, String n, String sh, String gender) {
        super(p, s, n, sh);
        Gender = gender;
    }
}

class shoe extends Apparel {
    int sizenum;

    shoe(double p, double s, String n, String sh, String gender, int sizenum) {
        super(p, s, n, sh, gender);
        this.sizenum = sizenum;
    }
}

class shirtorpants extends Apparel {
    String sizebody;

    shirtorpants(double p, double s, String n, String sh, String gender, String sizebody) {
        super(p, s, n, sh, gender);
        this.sizebody = sizebody;
    }
}

/**********************************/

