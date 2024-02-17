import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class moshtari {
    static List<String> ajnasekharidarishode = new ArrayList<>();
    static List<String> safeersal = new ArrayList<>();
    static List<String> myList = new ArrayList<>();
    static public String username;
    static List<String> myList2 = new ArrayList<>();
    static String[] listeuserandpass = new String[100];
    static long kharjemoshtari;
    static String password;

    public static void setmoshtari() {
        System.out.println("wellcome to Market");
        System.out.println("please set your username and password:");
        Scanner input = new Scanner(System.in);
        username = input.next();
        while (true) {
            if (myList.contains(username)) {
                System.out.println("please set another username");
                username = input.next();
            } else {
                myList.add(username);
                break;
            }
        }
        password = input.next();
        if (password.length() < 6) {
            System.out.println("your password's less than 6 charecter!");
            password = input.next();
        } else {
            myList2.add(password);
        }
        int i = 0;
        listeuserandpass[i] = username;
        i++;
        listeuserandpass[i] = password;
        i++;
    }

    public static void showlist() {
        for (String tolidkonande : tolidkonande.listetk) {
            System.out.print(admin.gettkUsername() + " ");
        }
        System.out.println();
        System.out.println("please enter your tolidkonande name");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        if (tolidkonande.listetk.contains(name)) {
            for (String kala : tolidkonande.listekalaha) {
                System.out.println(khoraki.getname());
            }
            for (String kala : tolidkonande.listekalaha2) {
                System.out.println(pooshak.getname());
            }
            for (String kala : tolidkonande.listekalaha3) {
                System.out.println(lavazemelctrici.getname());
            }
            System.out.println("do you want any product?");
            String awmser = input.next();
            if (awmser.contains("yes")) {
                System.out.println("please enter product name");
                String productname = input.next();
                ajnasekharidarishode.add(productname);
                safeersal.add(productname);
                tolidkonande.sood += aghlamvaajnas.price;
                kharjemoshtari += aghlamvaajnas.price;
                System.out.println("finished");
            }
        } else {
            System.out.println("your tolidkonande was not found");
        }
    }

    public static void showdastebandiajnas() {
        List<String> dastebandiajnas = new ArrayList<>();
        dastebandiajnas.add("mavade khoraki");
        dastebandiajnas.add("pooshak");
        dastebandiajnas.add("lavazeme electrici");
        for (int i = 0; i < dastebandiajnas.size(); i++) {
            System.out.print(dastebandiajnas.get(i) + " ");
        }
        System.out.println();
        System.out.println("chose your category");
        Scanner input = new Scanner(System.in);
        String category = input.nextLine();
        if (category.contains("mavade khoraki")) {
            for (String kala : tolidkonande.listekalaha) {
                System.out.println(khoraki.getname());
                System.out.println(khoraki.price);
                System.out.println(khoraki.Daste);
                System.out.println(khoraki.Hajm);
                System.out.println(khoraki.Tarikhengheza);
                System.out.println(khoraki.Sherkatsazande);
                System.out.println(khoraki.Shahresazande);
            }
        }
        if (category.contains("pooshak")) {
            for (String kala : tolidkonande.listekalaha2) {
                System.out.println(pooshak.getname());
                System.out.println(pooshak.price);
                System.out.println(pooshak.Daste);
                System.out.println(pooshak.Daste2);
                System.out.println(pooshak.hajm);
                System.out.println(pooshak.Size);
                System.out.println(pooshak.Size2);
                System.out.println(pooshak.Jens);
            }
        }
        if (category.contains("lavazeme electrici")) {
            for (String kala : tolidkonande.listekalaha3) {
                System.out.println(lavazemelctrici.getname());
                System.out.println(lavazemelctrici.price);
                System.out.println(lavazemelctrici.Daste);
                System.out.println(lavazemelctrici.SaleTolid);
                System.out.println(lavazemelctrici.Hajm);
                System.out.println(lavazemelctrici.SizeSafhe);
                System.out.println(lavazemelctrici.SherkateSazande);
            }
        }
        System.out.println("do you want any product?");
        String awmser = input.nextLine();
        if (awmser.contains("yes")) {
            System.out.println("please enter product name");
            String productname = input.nextLine();
            ajnasekharidarishode.add(productname);
            safeersal.add(productname);
            tolidkonande.sood++;
            kharjemoshtari++;
        }
    }

    public static void showlistekharidarishode() {
        // String list[] = (String[]) ajnasekharidarishode.toArray();
        for (String s : ajnasekharidarishode) {
            System.out.print(s + " ");
        }
    }

    public static void showsafeersal() {
        for (String s : safeersal) {
            System.out.println(s);
        }
    }
}