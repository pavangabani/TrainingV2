package socketprogramming.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL web = new URL("https://www.youtube.com/");
        System.out.println("protocol: "+web.getProtocol());
        System.out.println("host: "+web.getHost());
        System.out.println("port: "+web.getPort());
    }
}