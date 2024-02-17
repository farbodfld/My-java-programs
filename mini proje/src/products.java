import java.util.Scanner;

class aghlamvaajnas {
    static String Daste;
    static double Hajm;
    static double hajm;
    static int price;
    static String Shahresazande;
    static String SherkateSazande;
}

class khoraki extends aghlamvaajnas {
    Scanner input = new Scanner(System.in);


    static String Sherkatsazande;
    static int Tarikhengheza;

    static private String name;


    public static String setname() {
        Scanner input = new Scanner(System.in);
        System.out.println("set your product's name");
        name = input.nextLine();
        return name;
    }

    public static String getname() {
        return name;
    }

    public khoraki() {
        setname();
        System.out.println("set your price");
        price = input.nextInt();
        System.out.println("set your daste");
        Daste = input.next();//daste;
        System.out.println("set your hajm");
        Hajm = input.nextDouble();//hajm;
        System.out.println("set your sherkate sazande");
        Sherkatsazande = input.next();//sherkatsazande;
        System.out.println("set your tarikhe engheza");
        Tarikhengheza = input.nextInt();//tarikhengheza;
        System.out.println("do you want to set the city name?");
        String awnser = input.next();
        if (awnser.contains("yes")) {
            System.out.println("set your city name");
            Shahresazande = input.nextLine();
        }
    }
}

class pooshak extends aghlamvaajnas {
    Scanner input = new Scanner(System.in);
    static String Daste2;

    static int Size;
    static char Size2;
    static String Jens;
    static String name;


    public static String setname() {
        Scanner input = new Scanner(System.in);
        System.out.println("set your name");
        name = input.nextLine();
        return name;
    }

    public static String getname() {
        return name;
    }

    public pooshak() {                    // bara kafsh
        setname();
        System.out.println("set your price");
        price = input.nextInt();
        System.out.println("set your daste");
        Daste = input.nextLine();//daste;
        System.out.println("women or men or kids");
        Daste2 = input.nextLine();//daste2;  // mard zan bache
        System.out.println("set your hajm");
        hajm = input.nextDouble();
        System.out.println("set your jens");
        Jens = input.nextLine();//jens;
        System.out.println("set your size");
        Size = input.nextInt();//size;
        System.out.println("set your sherkate sazande");
        SherkateSazande = input.nextLine();
        System.out.println("is your product shirts or pants?");
        String awnser2 = input.next();
        if (awnser2.contains("yes")) {
            System.out.println("L or M or S");
            Size2 = input.next().charAt(0);
        }
    }
}

class lavazemelctrici extends aghlamvaajnas {
    Scanner input = new Scanner(System.in);
    static double SaleTolid;
    static double SizeSafhe;
    static String name;

    public static String setname() {
        Scanner input = new Scanner(System.in);
        System.out.println("set your name");
        String name = input.nextLine();
        return name;
    }

    public static String getname() {
        return name;
    }

    public lavazemelctrici() {
        setname();
        System.out.println("set your price");
        price = input.nextInt();
        System.out.println("set your daste");
        Daste = input.nextLine();//daste;
        System.out.println("set your hajm");
        hajm = input.nextDouble();
        System.out.println("set your sherkate sazande");
        SherkateSazande = input.nextLine();
        System.out.println("set your sale tolid");
        SaleTolid = input.nextDouble();//saletolid;
        System.out.println("set your size e safhe");
        SizeSafhe = input.nextDouble();//sizesafhe;
        System.out.println("is your product a counsole?");
        String awnser = input.next();
        if (awnser.contains("yes")) {
            System.out.println("how many fiture dose your console have?");
            int n = input.nextInt();
            String[] aghlamhamrah = new String[n];
            for (int i = 0; i < n; i++) {
                String x = input.nextLine();
                aghlamhamrah[i] = x;
            }
        }
    }
}