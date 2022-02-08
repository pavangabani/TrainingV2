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
        System.setProperty("javax.net.ssl.keyStore", "/home/pavan/IdeaProjects/TrainingV2/src/socketprogramming/socket/sslsocket/v2/clientkeystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");
        System.setProperty("javax.net.ssl.trustStore", "/home/pavan/IdeaProjects/TrainingV2/src/socketprogramming/socket/sslsocket/v2/clienttruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");
        try
        {
            SSLSocketFactory factory=(SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket=(SSLSocket) factory.createSocket("localhost",8444);

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