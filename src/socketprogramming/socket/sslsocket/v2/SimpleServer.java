package socketprogramming.socket.sslsocket.v2;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.security.cert.CertificateException;

public class SimpleServer {
    public static void main(String[] args) throws IOException, UnrecoverableKeyException, CertificateException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        System.setProperty("javax.net.ssl.keyStore", "/home/pavan/IdeaProjects/TrainingV2/src/socketprogramming/socket/sslsocket/v2/serverkeystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");
        System.setProperty("javax.net.ssl.trustStore", "/home/pavan/IdeaProjects/TrainingV2/src/socketprogramming/socket/sslsocket/v2/servertruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");
        int port = 8443;
        ServerSocketFactory factory = SSLServerSocketFactory.getDefault();
        try (ServerSocket listener = factory.createServerSocket(port)) {
            SSLServerSocket sslListener = (SSLServerSocket) listener;
            sslListener.setNeedClientAuth(true);
            sslListener.setEnabledCipherSuites(
                    new String[] { "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256" });
            sslListener.setEnabledProtocols(
                    new String[] { "TLSv1.2" });
            while (true) {
                try (Socket socket = sslListener.accept()) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Hello World!");
                }
            }
        }
    }
}
