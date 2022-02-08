package ssl;

import com.github.brainlag.nsq.NSQConfig;
import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.NSQMessage;
import com.github.brainlag.nsq.NSQProducer;
import com.github.brainlag.nsq.exceptions.NSQException;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProvider;
import onetoone.Nsq;

import javax.net.ssl.SSLException;
import java.io.File;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.Assert.assertEquals;


public class Main {
    private NSQConfig getSslConfig() throws SSLException {
        final NSQConfig config = new NSQConfig();
        File serverKeyFile = new File("/home/pavan/IdeaProjects/TrainingV2/NSQ/src/main/java/ssl/serverkeystore.jks");
        File clientKeyFile = new File("/home/pavan/IdeaProjects/TrainingV2/NSQ/src/main/java/ssl/clienttruststore.jks");
        File clientCertFile = new File("/home/pavan/IdeaProjects/TrainingV2/NSQ/src/main/java/ssl/server.cer");
        SslContext ctx = SslContextBuilder.forClient().sslProvider(SslProvider.OPENSSL).trustManager(serverKeyFile)
                .keyManager(clientCertFile, clientKeyFile).build();
        config.setSslContext(ctx);
        return config;
    }

    public static void main(String[] args) throws NSQException, TimeoutException, InterruptedException, SSLException {

        System.setProperty("io.netty.noJdkZlibDecoder", "false");
        AtomicInteger counter = new AtomicInteger(0);
        Main obj=new Main();

        //Lookup
        NSQLookup lookup = new DefaultNSQLookup();
        lookup.addLookupAddress(Nsq.getNsqLookupdHost(), 4161);

        //Producer
        NSQProducer producer = new NSQProducer();
        producer.setConfig(obj.getSslConfig());
        producer.addAddress(Nsq.getNsqdHost(), 4150);
        producer.start();

        String msg = "I am alien";
        producer.produce("OnetoOne", msg.getBytes());
        producer.shutdown();

        //Consumer
        NSQConsumer consumer = new NSQConsumer(lookup, "OnetoOne", "First", (message) -> {
            System.out.println( new String(message.getMessage()));
            counter.incrementAndGet();
            message.finished();
        }, obj.getSslConfig());
        consumer.start();

        while (counter.get() == 0) {
            Thread.sleep(500);
        }
        assertEquals(1, counter.get());
        consumer.shutdown();
    }
}
