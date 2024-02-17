import java.net.URL;

public class MyURL {
    public static void main(String[] args) throws Exception{
        URL url1 = new URL("https://www.google.com/search?source=hp&ei=THi_XtGlGYejgweM9KuQAg&q=java&oq=java&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BggAEAoQAToECAAQClCjBljHHGDYJmgCcAB4AIABkgKIAc0LkgEDMi02mAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjR--_K0bfpAhWH0eAKHQz6CiIQ4dUDCAY&uact=5");
        System.out.println("protocol: " + url1.getProtocol());
        System.out.println("host name: " + url1.getHost());
        System.out.println("port number: " + url1.getPort());
        System.out.println("defult port number: " + url1.getDefaultPort());
        System.out.println("path: " + url1.getPath());
        System.out.println("File: " + url1.getFile());
        System.out.println("Query: " + url1.getQuery());
    }
}
