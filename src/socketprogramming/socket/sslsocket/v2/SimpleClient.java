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
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String host = "localhost";
        int port = 8443;
        SocketFactory factory = SSLSocketFactory.getDefault();
        try (Socket connection = factory.createSocket(host, port)) {
            ((SSLSocket) connection).setEnabledCipherSuites(
                    new String[] { "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256" });
            ((SSLSocket) connection).setEnabledProtocols(
                    new String[] { "TLSv1.2" });

            SSLParameters sslParams = new SSLParameters();
            sslParams.setEndpointIdentificationAlgorithm("HTTPS");
            ((SSLSocket) connection).setSSLParameters(sslParams);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            System.out.println( input.readLine());
        }
    }
}

