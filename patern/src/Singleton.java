public class Singleton {
    // in moteghayer estefade mishe bara negahdari class singleton
    private static Singleton obj = new Singleton();

    // chon constructor ro nmikhaim dar ja haye dige estefade konim
    private Singleton() {}

    // in method ham bara bargardandane obj ke dorost kardim hast
    public static Singleton getInstance() {
        return obj;
    }
    // obj ba ravesh eagerly dar haman avale kar meghdar dehi shode ast agar ba raveshe lazy meghdar dehi mishod
    // mibayest dar method getinstance ba yek if meghdar dehi mikardim
}
