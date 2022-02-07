package socketprogramming.socket.sslsocket.v2;

import javax.net.SocketFactory;
import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.*;

public class SimpleClient {
    static String startClient(String host, int port) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        SocketFactory factory = SSLSocketFactory.getDefault();
        try (Socket connection = factory.createSocket(host, port)) {
            ((SSLSocket) connection).setEnabledCipherSuites(
                    new String[] { "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384"});
            ((SSLSocket) connection).setEnabledProtocols(
                    new String[] { "TLSv1.2"});
            SSLParameters sslParams = new SSLParameters();
            sslParams.setEndpointIdentificationAlgorithm("HTTPS");
            ((SSLSocket) connection).setSSLParameters(sslParams);
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            return input.readLine();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        System.out.println(startClient("localhost", 8443));
    }
}

