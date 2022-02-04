package chatgroup;

import com.github.brainlag.nsq.NSQProducer;
import onetoone.Nsq;

public class Group {
    String groupName;
    NSQProducer producer = new NSQProducer();
    Group(String groupName){
        this.groupName=groupName;
        producer.addAddress(Nsq.getNsqdHost(), 4150);
        producer.start();
    }
}
