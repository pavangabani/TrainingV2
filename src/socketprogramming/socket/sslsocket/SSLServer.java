package socketprogramming.socket.sslsocket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SSLServer {
    public static void main(String args[]) throws Exception
    {
        try{
            SSLServerSocketFactory factory=(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslserversocket=(SSLServerSocket) factory.createServerSocket(22);

            SSLSocket sslsocket=(SSLSocket) sslserversocket.accept();

            DataInputStream is=new DataInputStream(sslsocket.getInputStream());
            PrintStream os=new PrintStream(sslsocket.getOutputStream());
            while(true)
            {

                String input=is.readUTF();
                String message=input.toUpperCase();

                os.println(message);
            }
        }
        catch(IOException e)
        {
            System.out.print(e);
        }
    }
}
