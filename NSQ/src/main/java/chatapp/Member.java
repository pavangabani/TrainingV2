package chatapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.brainlag.nsq.NSQConfig;
import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.NSQProducer;
import com.github.brainlag.nsq.exceptions.NSQException;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;
import onetoone.Nsq;

import java.util.concurrent.TimeoutException;

public class Member {
    String memberName;
    NSQConsumer consumer;
    NSQProducer producer;
    ObjectMapper mapper = new ObjectMapper();
    NSQLookup lookup= new DefaultNSQLookup(mapper);

    Member(String memberName){
        this.memberName =memberName;
        lookup.addLookupAddress(Nsq.getNsqLookupdHost(), 4161);
        producer = new NSQProducer();
        producer.setConfig(getDeflateConfig());
        producer.addAddress(Nsq.getNsqdHost(), 4150);
        producer.start();
    }

    void message(String receiver,String message) throws NSQException, TimeoutException {
        message=memberName+":"+message;
        producer.produce(receiver, message.getBytes());
    }

    void read(){
        consumer = new NSQConsumer(lookup, memberName, "Main", (message) -> {
            String m=new String(message.getMessage());
            System.out.println(memberName+"'s Messages--> "+m);
            message.finished();
        });
        consumer.start();
    }

    private static NSQConfig getDeflateConfig() {
        final NSQConfig config = new NSQConfig();
        config.setCompression(NSQConfig.Compression.DEFLATE);
        config.setDeflateLevel(4);
        return config;
    }
}
