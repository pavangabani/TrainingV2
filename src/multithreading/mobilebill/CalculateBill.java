package multithreading.mobilebill;
//not completed
public class CalculateBill implements Runnable{
    int totalPrice=0,totalGST=0,totalServiceText=0,totalBill=0;
    MobileBill obj;

    CalculateBill(MobileBill obj){;
        this.obj=obj;
    }

    void calculate() throws InterruptedException {
        for(String key: obj.mobileBills.get(obj.total).keySet()){
            totalPrice=totalPrice+obj.mobileBills.get(obj.current).get(key);
        }
        Thread calculateGST=new Thread(new Runnable() {
            @Override
            public void run() {
                totalGST = (int) (totalPrice * 0.25);
            }
        });
        Thread calculateServiceText=new Thread(new Runnable() {
            @Override
            public void run() {
                totalServiceText= (int) (totalPrice*0.2);
            }
        });
        Thread calculateTotal=new Thread(new Runnable() {
            @Override
            public void run() {
                totalBill=totalPrice+totalGST+totalServiceText;
            }
        });
        calculateGST.start();
        calculateServiceText.start();
        calculateGST.join();
        calculateServiceText.join();
        calculateTotal.start();
        calculateTotal.join();
        obj.totalBillList.put(obj.current, totalBill);
    }

    @Override
    public void run() {
        try {
            calculate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
