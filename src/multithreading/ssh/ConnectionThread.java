package multithreading.ssh;

import com.jcraft.jsch.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionThread implements Runnable{
    String ip;
    ConnectionThread(String ip){
        this.ip=ip;
    }
    String inputStreamToString(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int ch; (ch = inputStream.read()) != -1; ) {
            sb.append((char) ch);
        }
        return sb.toString();
    }
    @Override
    public void run() {

        try {
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            JSch jsch=new JSch();
            Session session= null;
            session = jsch.getSession("pavan",ip,22);
            session.setPassword("Mind@123");
            session.setConfig(config);
            session.connect();

            System.out.println("Connected: " + ip);

            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand("free -m | grep Mem | awk '{print $2}';free -m | grep Mem | awk '{print $3}'");
            InputStream in=channel.getInputStream();

            channel.connect();
            String ans =inputStreamToString(in);

            String[] ansArray= ans.split("\n");
            float total=Float.valueOf(ansArray[0].trim());
            float used=Float.valueOf(ansArray[1].trim());

            float memoryUsage=(used/total)*100;
            System.out.println("Memory Usage: "+memoryUsage+" %");


        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
