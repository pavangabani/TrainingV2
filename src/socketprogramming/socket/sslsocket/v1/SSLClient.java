package socketprogramming.socket.sslsocket.v1;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;

public class SSLClient {
    public static void main(String args[])
    {
        try
        {
            SSLSocketFactory factory=(SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket=(SSLSocket) factory.createSocket("localhost",22);

            DataOutputStream os=new DataOutputStream(sslsocket.getOutputStream());
            DataInputStream is=new DataInputStream(sslsocket.getInputStream());

            String str="helloworld";
            os.writeBytes(str);

            String responseStr;
            if((responseStr=is.readUTF())!=null)
            {
                System.out.println(responseStr);
            }

            os.close();
            is.close();
            sslsocket.close();
        }
        catch(UnknownHostException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}