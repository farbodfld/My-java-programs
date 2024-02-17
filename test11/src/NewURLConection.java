import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class NewURLConection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.msn.com/en-xl/asia/bollywood/priyanka-chopra-jonas-dancing-to-the-beats-of-a-punjabi-track-is-what-you-need-to-brighten-up-your-weekend/ar-BB149re9?li=AAB4N9r");
            URLConnection urlc = url.openConnection();
            InputStream is = urlc.getInputStream();
            int i;
            while ((i = is.read()) != -1){
                System.out.print((char) i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
