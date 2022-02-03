package multithreading.billv3;

public class calculateGST implements Runnable{
    @Override
    public void run() {
        Main obj=new Main();
        for(String key: Main.bill.keySet()){
            double gst=Main.bill.get(key)*0.25;
            try {
                obj.calculateGST.put(gst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
