package chatgroup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.exceptions.NSQException;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;
import onetoone.Nsq;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class Member {
    Group group;
    String consumerName;
    NSQConsumer consumer;
    AtomicInteger counter = new AtomicInteger(0);
    ObjectMapper mapper = new ObjectMapper();
    NSQLookup lookup= new DefaultNSQLookup(mapper);

    Member(String consumerName, Group group){
        this.consumerName=consumerName;
        this.group=group;
        lookup.addLookupAddress(Nsq.getNsqLookupdHost(), 4161);
    }

    void read()  {
        consumer = new NSQConsumer(lookup, group.groupName, consumerName, (message) -> {
            String m=new String(message.getMessage());
            System.out.println(consumerName+"'s Messages: "+m);
            counter.incrementAndGet();
            message.finished();
        });
        consumer.start();
    }

    void write(String message) throws NSQException, TimeoutException, InterruptedException {
        group.producer.produce(group.groupName, message.getBytes());
    }

}
