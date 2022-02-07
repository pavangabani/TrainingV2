package socketprogramming.socket.sslsocket.v2;

import javax.net.ServerSocketFactory;
import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.security.cert.CertificateException;

public class SimpleServer {
    static void startServer(int port) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {

        System.setProperty("javax.net.ssl.keyStore", "/home/pavan/Desktop/Motadata/TrainingV2/src/socketprogramming/socket/sslsocket/v2/serverkeystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("/home/pavan/Desktop/Motadata/TrainingV2/src/socketprogramming/socket/sslsocket/v2/serverkeystore.jks"), "password".toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("X509");
        kmf.init(ks, "password".toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
        tmf.init(ks);

        SSLContext sc = SSLContext.getInstance("TLS");
        TrustManager[] trustManagers = tmf.getTrustManagers();
        sc.init(kmf.getKeyManagers(), trustManagers, null);

        ServerSocketFactory factory = SSLServerSocketFactory.getDefault();

        try (ServerSocket listener = factory.createServerSocket(port)) {
            ((SSLServerSocket) listener).setNeedClientAuth(true);
            ((SSLServerSocket) listener).setEnabledCipherSuites(
                    new String[] { "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384"});
            ((SSLServerSocket) listener).setEnabledProtocols(
                    new String[] { "TLSv1.2"});
            while (true) {
                try (Socket socket = listener.accept()) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Hello World!");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, UnrecoverableKeyException, CertificateException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        startServer(8443);
    }
}
