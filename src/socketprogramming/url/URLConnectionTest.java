package socketprogramming.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {
    public static void main(String[] args) throws IOException {
        URL web=new URL("https://www.youtube.com/");
        URLConnection webConnection=web.openConnection();
        InputStream urlInput=webConnection.getInputStream();
        int i;
        while((i=urlInput.read())!=-1){
            System.out.print((char)i);
        }
    }
}